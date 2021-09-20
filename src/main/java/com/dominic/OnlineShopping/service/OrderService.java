package com.dominic.OnlineShopping.service;

import com.dominic.OnlineShopping.entity.Item;
import com.dominic.OnlineShopping.entity.Order;
import com.dominic.OnlineShopping.entity.Product;
import com.dominic.OnlineShopping.entity.User;
import com.dominic.OnlineShopping.exceptions.DemandExceededStockException;
import com.dominic.OnlineShopping.resources.OrderResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final ProductService productService;
    private final OrderResource orderResource;
    private final ItemService itemService;
    private final CartService cartService;

    @Autowired
    public OrderService(
            ProductService productResource,
            OrderResource orderResource,
            ItemService itemResource,
            CartService cartService
    ) {
        this.productService = productResource;
        this.orderResource = orderResource;
        this.itemService = itemResource;
        this.cartService = cartService;
    }

    public void createOrderList(User user) {
        orderResource.save();
    }

    private void addOrderItem(Item item) {
        orderResource.save(new Order(item.getVendorID(), item.getID()));
    }

    private void addOrderItems(List<Item> items) {
        List<Order> orders = new ArrayList<>();
        for (Item item : items) {
            orders.add(new Order(item.getID(), item.getCustomerID()));
        }
        orderResource.saveAll(orders);
    }

    private void removeOrderItem(Item item) {
        orderResource.delete(orderResource.getOrderById(item.getVendorID()));
    }

    private void removeOrderItems(List<Item> items) {
        List<Order> orders = new ArrayList<>();
        for (Item item : items) {
            orders.add(new Order(item.getID(), item.getCustomerID()));
        }
        orderResource.deleteAll(orders);
    }

    //About to implement refund functionality. Refund just sends a negative value.
    public void updateProductStock(Long orderID) throws DemandExceededStockException {
        Order order = orderResource.getOrderById(orderID);
        Item item = itemService.getItemByID(order.getItemID());
        Product product = productService.getProductByID(item.getProductID());
        int stock = product.getStock();
        int quantity = item.getQuantity();

        if (quantity > stock) throw new DemandExceededStockException();
        product.setStock((quantity >= 0) ? stock - quantity : product.getStock() + quantity);
        productService.saveProduct(product);
    }

    /**
     * Checkout returns how many items failed to be ordered.
     * Ultimately adds the items in the orders table and remove the pushed items from cart.
     * @param cartID
     * @return number of failed orders.
     */
    public int checkout(Long cartID) {
        List<Item> items = cartService.getCartItemByCartID(cartID);
        int failed = 0;
        //Check each item if still available.
        for (Item item : items) {
            Product p = productService.getProductByID(item.getProductID());
            if (!productService.productAvailable(p.getID())) {
                failed++;
                items.remove(item);
            }
        }
        cartService.removeCartItems(items);
        addOrderItems(items);
        return failed;
    }

}























































