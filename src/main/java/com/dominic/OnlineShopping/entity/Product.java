package com.dominic.OnlineShopping.entity;

import javax.persistence.*;

/*
id BIGINT PRIMARY KEY,
    vid BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL,
    stock INTEGER DEFAULT(1),
    price DOUBLE DEFAULT(0.0),
    FOREIGN KEY(vid) REFERENCES user(id) ON DELETE CASCADE
 */

@Entity
@Table(name = "product")
public final class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "vendor_id")
    private Long vendorID;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "price")
    private Double price;

    public Product() {}

    public Product(Long vendorId, String name, String description, Integer stock, Double price) {
        this.vendorID = vendorId;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public Product(String name, String description, Integer stock, Double price) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public Long getID() {
        return ID;
    }

    public Long getVendorID() {
        return vendorID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStock() {
        return stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", vendorId=" + vendorID +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
