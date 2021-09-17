package com.dominic.OnlineShopping.resources;

import com.dominic.OnlineShopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface UserResource extends JpaRepository<User, Long> {
}
