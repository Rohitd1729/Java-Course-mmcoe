package com.mmcoe.stock;

public class Broker {

    private Stock stock;

    public Broker(Stock stock) {
        this.stock = stock;
    }

    public void getQuote() {
        System.out.println("Broker : " + stock.getQuote());
    }
}