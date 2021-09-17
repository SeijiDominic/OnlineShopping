package com.dominic.OnlineShopping.service;

import com.dominic.OnlineShopping.entity.Product;
import com.dominic.OnlineShopping.resources.ProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductResource productResource;

    @Autowired
    public ProductService(ProductResource productResource) {
        this.productResource = productResource;
    }

    public Product getProductById(Long id) {
        return productResource.getProductById(id);
    }



}
