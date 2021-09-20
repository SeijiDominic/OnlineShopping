package com.dominic.OnlineShopping.resources;

import com.dominic.OnlineShopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface UserResource extends JpaRepository<User, Long> {
    User getUserById(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM user AS u;")
    List<User> getUsers();
    void deleteUserById(Long id);
}
