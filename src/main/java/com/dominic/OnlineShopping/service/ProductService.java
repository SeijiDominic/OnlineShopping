package com.dominic.OnlineShopping.service;

import com.dominic.OnlineShopping.entity.Product;
import com.dominic.OnlineShopping.resources.ProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductResource productResource;
    private final CartService cartService;

    @Autowired
    public ProductService(
            ProductResource productResource,
            CartService cartService
    ) {
        this.productResource = productResource;
        this.cartService = cartService;
    }

    public Product getProductByID(Long id) {
        return productResource.getProductById(id);
    }


    public List<Product> getProductsByVendorID(Long id) {
        return productResource.getProductsByVendor(id);
    }

    public void saveProduct(Product product) {
        productResource.save(product);
    }

    public void deleteProductById(Long id) {
        productResource.deleteProductById(id);
    }

    public void updateProductStock(Long productID, Integer quantity) {
        Product product = productResource.getProductById(productID);
        product.setStock(quantity);
        saveProduct(product);
    }

    public boolean productAvailable(Long productID) {
        Product product = productResource.getProductById(productID);
        return product.getStock() > 0;
    }


}
