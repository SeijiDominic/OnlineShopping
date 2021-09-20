package com.dominic.OnlineShopping.service;

import com.dominic.OnlineShopping.entity.User;
import com.dominic.OnlineShopping.resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final UserResource userResource;

    @Autowired
    public UserService(UserResource userResource) {
        this.userResource = userResource;
    }

    public User getUserById(Long id) {
        return userResource.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userResource.getUsers();
    }

    public void saveUser(User user) {
        System.out.println(user);
        userResource.save(user);
    }

    public void deleteUser(Long id) {
        userResource.deleteUserById(id);
    }
}
