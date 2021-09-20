package com.dominic.OnlineShopping.controllers;

import com.dominic.OnlineShopping.entity.User;
import com.dominic.OnlineShopping.service.CartService;
import com.dominic.OnlineShopping.service.OrderService;
import com.dominic.OnlineShopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    private final CartService cartService;
    private final OrderService orderService;

    @Autowired
    public UserController(
            UserService userService,
            CartService cartService,
            OrderService orderService
    ) {
        this.userService = userService;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(
            @RequestBody User user
    ) {
        userService.saveUser(user);
        cartService.createCart(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createVendor(
            @RequestBody User user
    ) {
        createUser(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<User> getUserById(
            @RequestParam Long id
    ) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/users/delete")
    @Transactional
    public ResponseEntity<?> deleteUserById(
            @RequestParam Long id
    ) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}































