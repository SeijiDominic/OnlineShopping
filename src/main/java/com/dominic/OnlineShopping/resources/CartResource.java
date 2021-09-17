package com.dominic.OnlineShopping.resources;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartResource extends JpaRepository<Cart, Long> {
}
