package com.dominic.OnlineShopping.controllers;

import com.dominic.OnlineShopping.resources.ItemResource;
import com.dominic.OnlineShopping.service.ItemService;
import com.dominic.OnlineShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    private final ProductService productService;
    private final ItemService cartItemService;

    @Autowired
    public ItemController(ItemService cartItemService, ProductService productService) {
        this.cartItemService = cartItemService;
        this.productService = productService;
    }



}
