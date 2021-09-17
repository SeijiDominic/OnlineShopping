package com.dominic.OnlineShopping.entity;

import com.dominic.OnlineShopping.model.Vendor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private Long id;
    @Column(name = "vid")
    private Long vid;
    @Column(name = "name")
    private String name;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "price")
    private Double price;

    public Product() {}

    public Product(Long vid, String name, Integer stock, Double price) {
        this.vid = vid;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }


    public Long getVendor() {
        return vid;
    }

    public String getName() {
        return name;
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
        return String.format("Name: %s\n Vendor: %s\n Price: %.2f\n Available: %d\n", name, vid, price, stock);
    }
}
