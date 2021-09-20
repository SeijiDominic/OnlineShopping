package com.dominic.OnlineShopping.entity;


import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "cart_id")
    private Long cartID;

    @Column(name = "customer_id")
    private Long customerID;

    @Column(name = "product_id")
    private Long productID;

    @Column(name = "vendor_id")
    private Long vendorID;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total")
    private Double total;

    public Item() {}

    public Item(Long ID, Long cartID, Long customerID, Long productID, Long vendorID, Integer quantity, Double total) {
        this.ID = ID;
        this.cartID = cartID;
        this.customerID = customerID;
        this.productID = productID;
        this.vendorID = vendorID;
        this.quantity = quantity;
        this.total = total;
    }
    public Item(Long cartID, Long customerID, Long productID, Long vendorID, Integer quantity, Double total) {
        this.cartID = cartID;
        this.customerID = customerID;
        this.productID = productID;
        this.vendorID = vendorID;
        this.quantity = quantity;
        this.total = total;
    }

    public Long getID() {
        return ID;
    }

    public Long getCartID() {
        return cartID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public Long getProductID() {
        return productID;
    }

    public Long getVendorID() {
        return vendorID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
