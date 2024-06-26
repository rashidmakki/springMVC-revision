package com.security.jwt.springsecuritywithdb.service;

import com.security.jwt.springsecuritywithdb.model.User;
import com.security.jwt.springsecuritywithdb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> findAllUser() {
        return this.userRepository.findAll();
    }

    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of("ROLE_USER"));
        return this.userRepository.save(user);
    }

    public User findUserByEmail(String username) {
        return this.userRepository.findByEmail(username);
    }
}
