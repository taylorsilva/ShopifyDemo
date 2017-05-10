package com.taylorsilva.shopify.ResponseBody;

import java.util.List;

/**
 * Created by taylor on 2017-05-09.
 *
 * Follows this JSON structure:
 * https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6
 */

public class Orders {
    private List<OrderDetails> orders;

    public List<OrderDetails> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetails> orders) {
        this.orders = orders;
    }
}
