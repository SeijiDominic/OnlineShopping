package com.dominic.OnlineShopping.resources;

import com.dominic.OnlineShopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface ProductResource extends JpaRepository<Product, Long> {
    Product getProductById(Long id);
}
