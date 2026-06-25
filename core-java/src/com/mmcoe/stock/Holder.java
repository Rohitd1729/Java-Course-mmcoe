package com.mmcoe.stock;

public class Holder {

    private Stock stock;

    public Holder(Stock stock) {
        this.stock = stock;
    }

    public void viewQuote() {
        System.out.println("Holder : " + stock.getQuote());
    }
}