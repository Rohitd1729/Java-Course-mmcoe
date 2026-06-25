package com.mmcoe.cart;

public class ShoppingCart implements Shopping {

    private Product[] items;
    private double total;
    private int count;

    public ShoppingCart() {
        items = new LinkedList<Product>();
        count = 0;
        total = 0;
    }

    @Override
    public void addToCart(Product p) throws CartException {

        if (count == items.length)
            throw new CartException("Your cart is full");

        items[count++] = p;
        total += p.getPrice();
    }

    @Override
    public void checkout() {

        System.out.println("Items in Cart");

        for(int i=0;i<count;i++)
            System.out.println(items[i]);

        System.out.println("-------------------");
        System.out.println("Total = " + total);
    }
}