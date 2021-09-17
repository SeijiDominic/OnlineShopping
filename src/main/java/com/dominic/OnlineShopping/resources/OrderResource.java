package com.dominic.OnlineShopping.resources;

import com.dominic.OnlineShopping.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderResource extends JpaRepository<Order, Long> {
    Order getOrderById(Long id);
}
