package com.dominic.OnlineShopping.model;

import com.dominic.OnlineShopping.entity.User;

import java.util.ArrayList;

public final class Vendor {
    private User user;
//    private static ProductList products;
    private OrderList orders;

    public Vendor(String firstName, String lastName) {
    }

//    public ProductList getItems() {
//        return products;
//    }

    public OrderList getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return String.format("%s %s");
    }
}
