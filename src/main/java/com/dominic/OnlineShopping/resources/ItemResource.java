package com.dominic.OnlineShopping.resources;

import com.dominic.OnlineShopping.entity.Item;
import com.dominic.OnlineShopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface ItemResource extends JpaRepository<Item, Long> {
    Item getItemByID(Long id);
    List<Item> getItemsByCartID(Long id);


}
