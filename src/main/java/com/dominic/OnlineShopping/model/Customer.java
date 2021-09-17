package com.dominic.OnlineShopping.model;

import com.dominic.OnlineShopping.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public final class Customer {
    private User user;
    private final OrderList cart;

    public Customer(User user) {
        this.user = user;
        this.cart = new OrderList();

    }

    public OrderList getCart() {
        return cart;
    }

    private void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s\nShopping Cart: %s", user.getFirstName(), user.getLastName(), cart);
    }

}
