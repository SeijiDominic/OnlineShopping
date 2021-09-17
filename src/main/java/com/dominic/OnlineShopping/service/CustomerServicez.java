package com.dominic.OnlineShopping.service;


import com.dominic.OnlineShopping.entity.User;
import com.dominic.OnlineShopping.model.Customer;
import com.dominic.OnlineShopping.entity.Order;
import com.dominic.OnlineShopping.model.OrderList;
import org.springframework.stereotype.Service;

/**
 * This is where I put all customer's behavior and actions.
 */
@Service
public class CustomerServicez {
    private final ShoppingCartService cart;

    public CustomerServicez(ShoppingCartService shoppingCartService) {
        this.cart = shoppingCartService;
    }





    private static Customer customer;
    private static boolean initComplete = false;

    public void initCustomer(User user) {
        customer = new Customer(user);
        cart = customer.getCart();
        initComplete = true;
        System.out.println("Customer init complete!");
    }

    public void addProductToCart(Order order) {
        if (initComplete) {
            cart.addToList(order);
        }
//        else {
//            throw new InitializationIncompleteException("Customer and cart not initialized");
//        }
    }

    public void removeProductFromCart(Order order) {
        if (initComplete) {
            cart.removeFromList(order);
        }
//        else {
//            throw new InitializationIncompleteException("Customer and cart not initialized");
//        }

    }

    public Customer getCustomer() {
        if (initComplete) {

        }
//        else {
//            throw new InitializationIncompleteException("Customer and cart not initialized");
//        }
        return customer;
    }

    public OrderList getCart() {
        if (initComplete) {

        }
//        else {
//            throw new InitializationIncompleteException("Customer and cart not initialized");
//        }
        return cart;
    }
}

