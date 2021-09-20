package com.dominic.OnlineShopping.service;

import com.dominic.OnlineShopping.entity.*;
import com.dominic.OnlineShopping.exceptions.DemandExceededStockException;
import com.dominic.OnlineShopping.resources.CartResource;
import com.dominic.OnlineShopping.resources.OrderResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private final CartResource cartResource;
    private final ProductService productService;
    private final OrderResource orderResource;
    private final ItemService itemService;


    @Autowired
    public CartService(
            CartResource cartResource,
            ProductService productService,
            OrderResource orderResource,
            ItemService itemResource) {
        this.cartResource = cartResource;
        this.productService = productService;
        this.orderResource = orderResource;
        this.itemService = itemResource;
    }

    public Cart getCartById(Long id) {
        return cartResource.getCartById(id);
    }

    public void createCart(User user) {
        cartResource.save(new Cart(user.getID()));
    }

    public List<Item> getCartItemByCartID(Long cartID) {
        return itemService.getItemsByCartID(cartID);
    }

    public void addCartItem(Item item) {
        cartResource.save(new Cart(item.getCustomerID()));
    }

    public void addCartItems(Iterable<Item> items) {
        List<Cart> cartItems= new ArrayList<>();
        for (Item item : items) {
            cartItems.add(new Cart(item.getCustomerID()));
        }
        cartResource.saveAll(cartItems);
    }

    public void removeCartItem(Item item) {
        cartResource.delete(cartResource.getCartById(item.getCartID()));
    }

    public void removeCartItems(Iterable<Item> items) {
        ArrayList<Cart> c = new ArrayList<>();
        for (Item item : items) {
            c.add(cartResource.getCartById(item.getCartID()));
        }
        cartResource.deleteAll(c);
    }

    public void removeCartItemByItemID(Long itemID) {
        Item i = itemService.getItemByID(itemID);
        cartResource.delete(cartResource.getCartById(i.getCartID()));
    }

//    //About to implement refund functionality. Refund just sends a negative value.
//    public void updateProductStock(Long itemID) throws DemandExceededStockException {
//        Item item = itemService.getItemByID(itemID);
//        Product product = productService.getProductByID(item.getProductID());
//        int stock = productService.getProductByID(item.getProductID()).getStock();
//        int quantity = product.getStock();
//
//        if (quantity > stock) throw new DemandExceededStockException();
//        product.setStock((quantity >= 0) ? stock - quantity : product.getStock() + quantity);
//    }

}



























































