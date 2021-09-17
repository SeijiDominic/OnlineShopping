package com.dominic.OnlineShopping.entity;

import com.dominic.OnlineShopping.model.OrderList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    @Column(name="first")
    private String firstName;
    @Column(name="last")
    private String lastName;
    @Column(name="address")
    private String address;
    @Column(name = "isvendor")
    private Boolean isVendor;


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}
