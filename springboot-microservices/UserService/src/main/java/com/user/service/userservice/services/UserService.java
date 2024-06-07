package com.user.service.userservice.services;

import com.user.service.userservice.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(String userId);
}
