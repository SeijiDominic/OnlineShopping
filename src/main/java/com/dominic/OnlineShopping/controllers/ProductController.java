package com.dominic.OnlineShopping.controllers;

import com.dominic.OnlineShopping.entity.Product;
import com.dominic.OnlineShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/user/products")
    public ResponseEntity<List<Product>> getProductByUserId(
            @RequestParam Long id
    ) {
        // TODO: 9/18/21 retrieve products using pre loaded user.

        return new ResponseEntity<>(productService.getProductsByVendorID(id), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<Product> getProductById(
            @RequestParam Long id
    ) {
        return new ResponseEntity<>(productService.getProductByID(id), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> saveProduct(
            @RequestBody Product product
    ) {
//        System.out.println(product);
        productService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/products/delete")
    @Transactional
    public ResponseEntity<?> deleteProductById(
            @RequestParam Long productID
    ) {
        productService.deleteProductById(productID);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
