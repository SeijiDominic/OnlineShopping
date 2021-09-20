package com.dominic.OnlineShopping.controllers;

import com.dominic.OnlineShopping.entity.Item;
import com.dominic.OnlineShopping.service.ItemService;
import com.dominic.OnlineShopping.service.CartService;
import com.dominic.OnlineShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;
    private final ProductService productService;
    private final ItemService itemService;

    @Autowired
    public CartController(
            CartService cartService,
            ItemService cartItemService,
            ProductService productService) {
        this.cartService = cartService;
        this.itemService = cartItemService;
        this.productService = productService;
    }

//    @GetMapping("/cart")
//    public Cart getCartById(
//            @RequestParam Long id
//    ) {
//        return cartService.getCartById(id);
//    }

    @GetMapping("/cart")
    public ResponseEntity<List<Item>> getCartItemsByCartID(
            @RequestParam Long cartID
    ) {
        List<Item> items = cartService.getCartItemByCartID(cartID);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/cart")
    public ResponseEntity<?> addItemToCart(Item cartItem) {
        cartService.addCartItem(cartItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/cart")
    public ResponseEntity<?> addItemsToCart(
            @RequestBody List<Item> items
    ) {
        cartService.addCartItems(items);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/products/delete/{item}")
    public ResponseEntity<?> removeCartItem(
            @PathVariable Item item
    ) {
        cartService.removeCartItem(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/products/delete/{items}")
    public ResponseEntity<?> removeCartItems(
            @PathVariable List<Item> items
    ) {
        cartService.removeCartItems(items);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}



























































