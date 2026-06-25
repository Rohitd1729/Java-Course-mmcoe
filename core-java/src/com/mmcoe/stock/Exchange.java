package com.mmcoe.stock;

public class Exchange {

    private Stock stock;

    public Exchange(Stock stock) {
        this.stock = stock;
    }

    public void setQuote(double price) {
        stock.setQuote(price);
    }
}