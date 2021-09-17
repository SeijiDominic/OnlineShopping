package com.dominic.OnlineShopping.controllers;

import com.dominic.OnlineShopping.entity.User;
import com.dominic.OnlineShopping.service.CustomerService;
import com.dominic.OnlineShopping.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CustomerController {
    private final CustomerService customerService;
    private final VendorService vendorService;

    @Autowired
    public CustomerController(CustomerService customerService, VendorService vendorService) {
        this.customerService = customerService;
        this.vendorService = vendorService;

    }

    @PostMapping("/login")
    public void initCustomer(
            @RequestBody User user
    ) {
        customerService.initCustomer(user);
    }
}
