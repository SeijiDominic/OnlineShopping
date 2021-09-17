package com.dominic.OnlineShopping.service;

import com.dominic.OnlineShopping.entity.Order;
import com.dominic.OnlineShopping.model.OrderList;
import com.dominic.OnlineShopping.resources.OrderResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
I want to someday, do this process using cookies.
 */
@Service //This is where I start pushing the orders to the DB.
public class OrderListService {
    private final OrderResource orderResource;

    @Autowired
    public OrderListService(OrderResource orderResource) {
        this.orderResource = orderResource;
    }


    public void updateOrder() {
        for (Order order : list) {
            order.updateProductStock();
            this.total += order.getTotal();
        }
    }

    public void addToList(Order order) {
        total += order.getTotal();
        this.list.add(order);
    }

    public void addToList(OrderList orderList) {
        for (Order order : orderList.list) {
            total += order.getTotal();
        }
        this.list.addAll(orderList.getList());
    }


    public void removeFromList(Order order) {
        total -= order.getTotal();
        this.list.remove(order);
    }

}
