package com.mmcoe.cart;

public interface Shopping {

    void addToCart(Product p) throws CartException;

    void checkout();
}