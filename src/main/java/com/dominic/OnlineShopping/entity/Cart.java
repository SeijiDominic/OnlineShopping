package com.dominic.OnlineShopping.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "customer_id")
    private Long customerID;

    public Cart() {}

    public Cart(Long id, Long customerId) {
        this.ID = id;
        this.customerID = customerId;
    }

    public Cart(Long customerId) {
        this.customerID = customerId;
    }

    public Long getID() {
        return ID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "ID=" + ID +
                ", customerID=" + customerID +
                '}';
    }
}
