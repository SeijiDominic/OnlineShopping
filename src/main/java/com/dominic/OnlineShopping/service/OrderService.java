package com.dominic.OnlineShopping.service;

import com.dominic.OnlineShopping.entity.Order;
import com.dominic.OnlineShopping.entity.Product;
import com.dominic.OnlineShopping.exceptions.DemandExceededStockException;
import com.dominic.OnlineShopping.resources.OrderResource;
import com.dominic.OnlineShopping.resources.ProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ProductResource productResource;
    private final OrderResource orderResource;

    @Autowired
    public OrderService(ProductResource productResource, OrderResource orderResource) {
        this.productResource = productResource;
        this.orderResource = orderResource;
    }


    //About to implement refund functionality. Refund just sends a negative value.
    public void updateProductStock(Long oid) throws DemandExceededStockException {
        Order order = orderResource.getOrderById(oid);
        Product product = productResource.getProductById(order.getPid());
        Integer quantity = product.getStock();

        if (quantity > product.getStock()) throw new DemandExceededStockException();

        if (quantity >= 0) {
            product.setStock(product.getStock() - quantity);
        } else {
            product.setStock(product.getStock() + quantity);
        }
    }
}
