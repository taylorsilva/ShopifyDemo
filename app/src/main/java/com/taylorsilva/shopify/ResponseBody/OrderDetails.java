package com.taylorsilva.shopify.ResponseBody;

import java.util.List;

/**
 * Created by taylor on 2017-05-09.
 * Part of nested JSON
 */

public class OrderDetails {
    private long id;
    private Double total_price;
    private Double total_price_usd;
    private List<LineItems> line_items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = Double.parseDouble(total_price);
    }


    public Double getTotal_price_usd() {
        return total_price_usd;
    }

    public void setTotal_price_usd(String total_price_usd) {
        this.total_price_usd = Double.parseDouble(total_price_usd);
    }

    public List<LineItems> getLine_items() {
        return line_items;
    }

    public void setLine_items(List<LineItems> line_items) {
        this.line_items = line_items;
    }
}
