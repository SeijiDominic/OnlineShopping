package com.dominic.OnlineShopping.resources;

import com.dominic.OnlineShopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface ProductResource extends JpaRepository<Product, Long> {
    Product getProductById(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM product AS p WHERE vendor_id = :id")
    List<Product> getProductsByVendor(@Param("id") Long id);

    void deleteProductById(Long id);
}
