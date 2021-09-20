package com.dominic.OnlineShopping.service;

import com.dominic.OnlineShopping.entity.Item;
import com.dominic.OnlineShopping.entity.Product;
import com.dominic.OnlineShopping.resources.ItemResource;
import com.dominic.OnlineShopping.resources.ProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemResource itemResource;
    private final ProductResource productResource;

    @Autowired
    public ItemService(ItemResource cartItemResource, ProductResource productResource) {
        this.itemResource = cartItemResource;
        this.productResource = productResource;
    }

    public Item getItemByID(Long itemID) {
        return itemResource.getItemByID(itemID);
    }

    public List<Item> getItemsByCartID(Long cartID) {
        return itemResource.getItemsByCartID(cartID);
    }

    public Item createItem(Long cartID, Long customerID, Long productID, Integer qty) {
        Product product = productResource.getProductById(productID);
        Double subtotal = product.getPrice() * qty;
        return new Item(cartID, customerID, productID, product.getVendorID(), qty, subtotal);
    }
}
