package com.taylorsilva.shopify.ResponseBody;

/**
 * Created by taylor on 2017-05-09.
 * Part of nested JSON
 */

public class LineItems {
    private String title;
    private int quantity;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
