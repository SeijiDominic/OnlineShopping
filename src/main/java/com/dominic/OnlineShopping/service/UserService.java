package com.dominic.OnlineShopping.service;

import com.dominic.OnlineShopping.resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserResource userResource;

    @Autowired
    public UserService(UserResource userResource) {
        this.userResource = userResource;
    }

}
