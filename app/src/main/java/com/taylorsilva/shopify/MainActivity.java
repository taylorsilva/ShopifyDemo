package com.taylorsilva.shopify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.keyboards) TextView keyboards;
    @BindView(R.id.revenue_cad) TextView revenueCad;
    @BindView(R.id.revenue_usd) TextView revenueUsd;
    ShopifyDataStore shopifyDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        shopifyDataStore = new ShopifyDataStore();
    }

    @Override
    protected void onStart() {
        super.onStart();
        refresh();
    }

    @OnClick(R.id.refresh_button)
    public void refresh() {
        shopifyDataStore.refreshOrders(new Callback() {
            @Override
            public void onComplete() {
                setRevenueCad();
                setRevenueUsd();
                setKeyboards();
            }
        });
    }

    private void setKeyboards() {
        String total = Integer.toString(shopifyDataStore.getCottonKeyboardsSold());
        keyboards.setText(total);
    }

    private void setRevenueCad() {
        String total = String.format(Locale.CANADA, "$%.2f", shopifyDataStore.getRevenueCad());
        revenueCad.setText(total);
    }

    private void setRevenueUsd() {
        String total = String.format(Locale.CANADA, "$%.2f", shopifyDataStore.getRevenueUsd());
        revenueUsd.setText(total);
    }
}
