package com.dominic.OnlineShopping.service;

import com.dominic.OnlineShopping.entity.Order;
import com.dominic.OnlineShopping.model.OrderList;
import com.dominic.OnlineShopping.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
I just realized, this process should be done in the front end, but whatever.
 */
@Service
public class ShoppingCartService {
    private final CustomerService customerService;
    private final VendorService vendorService;
    private final ProductService productService;

    @Autowired
    public ShoppingCartService(
            CustomerService customerService,
            VendorService vendorService,
            ProductService productService) {
        this.customerService = customerService;
        this.vendorService = vendorService;
        this.productService = productService;
    }

    /**
     * Check for currently existing Order to avoid multiple instances of Order of the same product.
     * @param pid id of the Product to order.
     * @return Optional Order
     */
    public Optional<Order> existingOrder(Long pid) {
        List<Order> orders = customerService.getCustomer().getCart().getList();
        Product product = productService.getProductById(pid);
        return orders.stream()
                .filter(o -> !productService.getProductById(o.getPid()).equals(product))
                .findFirst();
    }

    /**
     * Using streams, check if the order already exists. If so, override the quantity field.
     * Create a new Order instance, otherwise.
     *
     * WHY??
     * I want to give users the ability to reduce the qty of product one by one once they
     * entered a mistyped product quantity.
     *
     * Also, for efficient processing.
     * @param pid id of the Product to order.
     * @param qty Product quantity.
     */
    public void addItemToCart(Long pid, Integer qty) {
        Optional<Order> order = existingOrder(pid);
        Order newOrder = new Order(pid, qty);

        if (order.isPresent()) {
            customerService.removeProductFromCart(order.get());
        } else if (qty != 0) {
            customerService.addProductToCart(newOrder);
        }
    }

    /**
     * As the name suggests, removes currently existing Order, WHOLE...
     * @param pid id of the Product that is contained in the Order.
     */
    public void removeItemFromCart(Long pid) {
        Optional<Order> order = existingOrder(pid);

        if (order.isPresent()) {
            customerService.removeProductFromCart(order.get());
        } else {
            System.out.println("Such order does not exist.");
        }
    }

    /**
     * Send a copy of the shopping cart to the vendor to manage inventory. To be implemented.
     */
    public void checkout() throws CloneNotSupportedException {
        OrderList orders = (OrderList) customerService.getCart().clone();


        // TODO: 03/06/2021 More implementations here pls. thx.


        vendorService.registerOrder(orders);
    }
}

























































