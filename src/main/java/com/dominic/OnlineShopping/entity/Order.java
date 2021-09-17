package com.dominic.OnlineShopping.entity;

import com.dominic.OnlineShopping.entity.Product;
import com.dominic.OnlineShopping.exceptions.DemandExceededStockException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
    @Id
    private Long id;
    @Column(name = "cid")
    private Long cid;
    @Column(name = "pid")
    private Long pid;
    private Integer quantity;
    private Double total = 0.0;

    public Order() {}

    public Order(Long pid, Integer quantity) {
        this.pid = pid;
    }

    public Long getId() {
        return id;
    }

    public Double getTotal() {
        return total;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getCid() {
        return cid;
    }

    public Long getPid() {
        return pid;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return String.format("PID: %s\nQuantity: %d\nSub-total: %.2f", pid, quantity, total);
    }
}
