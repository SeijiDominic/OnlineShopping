package com.dominic.OnlineShopping.resources;

import com.dominic.OnlineShopping.entity.Cart;
import com.dominic.OnlineShopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartResource extends JpaRepository<Cart, Long> {
    Cart getCartById(Long id);
}
