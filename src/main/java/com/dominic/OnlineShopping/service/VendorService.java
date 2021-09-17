package com.dominic.OnlineShopping.service;

import com.dominic.OnlineShopping.entity.Order;
import com.dominic.OnlineShopping.model.OrderList;
import com.dominic.OnlineShopping.model.Vendor;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    private final Vendor vendor;
//    private final ProductList products;
    private final OrderList orders;


    public VendorService(Vendor vendor) {
        this.vendor = vendor;
//        this.products = vendor.getItems();
        this.orders = vendor.getOrders();
    }


    public void addOrder(Order order) {
        this.orders.addToList(order);
    }

    public void addOrder(OrderList orders) {
        this.orders.addToList(orders);
    }

    public void registerOrder(OrderList orders) {
        addOrder(orders);
    }


    public Vendor getVendor() {
        return vendor;
    }

    public OrderList getOrders() {
        return orders;
    }

}







































