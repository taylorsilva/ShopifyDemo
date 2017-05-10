package com.taylorsilva.shopify;

import com.taylorsilva.shopify.ResponseBody.Orders;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by taylor on 2017-05-09.
 */

public interface ShopifyService {

    @GET("admin/orders.json")
    Call<Orders> getOrders(@Query("page") int page, @Query("access_token") String token);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://shopicruit.myshopify.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
