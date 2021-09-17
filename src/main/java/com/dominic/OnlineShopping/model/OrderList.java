package com.dominic.OnlineShopping.model;

import com.dominic.OnlineShopping.entity.Order;
import com.dominic.OnlineShopping.entity.User;

import java.util.ArrayList;
import java.util.List;

public class OrderList implements Cloneable {
    private final List<Order> list;
    private Double total = 0.0;

    public OrderList() {
        list = new ArrayList<>();
    }

    public List<Order> getList() {
        return list;
    }

    public Double getTotal() {
        return total;
    }

    public Integer getSize() {
        return this.list.size();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Order o : list) {
            sb.append(o).append("\n");
        }

        return String.format("Orders {\n%s\nTotal Amount: %s\n}", sb.toString(), total);
    }
}








































