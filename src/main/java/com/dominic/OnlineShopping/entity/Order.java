package com.dominic.OnlineShopping.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "vendor_id")
    private Long vendorID;

    @Column(name = "item_id")
    private Long itemID;

    public Order() {}

    public Order(Long ID, Long vendorID, Long itemID) {
        this.ID = ID;
        this.vendorID = vendorID;
        this.itemID = itemID;
    }

    public Order(Long vendorID, Long itemID) {
        this.vendorID = vendorID;
        this.itemID = itemID;
    }

    public Long getID() {
        return ID;
    }


    public Long getVendorID() {
        return vendorID;
    }

    public Long getItemID() {
        return itemID;
    }
}
