package com.taylorsilva.shopify;

import android.util.Log;

import com.taylorsilva.shopify.ResponseBody.LineItems;
import com.taylorsilva.shopify.ResponseBody.OrderDetails;
import com.taylorsilva.shopify.ResponseBody.Orders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by taylor on 2017-05-09.
 */

public class ShopifyDataStore {
    private List<OrderDetails> orders;
    private ShopifyService shopifyService;
    private int page = 1;
    private String token = "c32313df0d0ef512ca64d5b336a0d7c6";
    private String TAG = "ShopifyDS";

    public double getRevenueCad() {
        Double revenue = 0.0;

        for (OrderDetails order: orders) {
            revenue += order.getTotal_price();
        }

        return revenue;
    }

    public double getRevenueUsd() {
        Double revenue = 0.0;

        for (OrderDetails order: orders) {
            revenue += order.getTotal_price_usd();
        }

        return revenue;
    }

    public int getCottonKeyboardsSold() {
        int keyboards = 0;

        for (OrderDetails order: orders) {
            List<LineItems> lineItems = order.getLine_items();
            for (LineItems lineItem: lineItems) {
                if (lineItem.getTitle().equals("Aerodynamic Cotton Keyboard")) {
                    keyboards += lineItem.getQuantity();
                }
            }
        }

        return keyboards;
    }

    public void refreshOrders(com.taylorsilva.shopify.Callback callback) {
        orders = null;
        getOrders(callback);
    }

    private void getOrders(final com.taylorsilva.shopify.Callback callback) {
        if (orders != null) {
            return;
        }

        if (shopifyService == null) {
            shopifyService = ShopifyService.retrofit.create(ShopifyService.class);
        }

        shopifyService.getOrders(page, token).enqueue(new Callback<Orders>() {
            @Override
            public void onResponse(Call<Orders> call, Response<Orders> response) {
                Log.d(TAG, response.toString());
                orders = response.body().getOrders();
                callback.onComplete();
            }

            @Override
            public void onFailure(Call<Orders> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }
}
