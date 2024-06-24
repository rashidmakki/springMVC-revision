package com.jwt.springsecurity.service;

import com.jwt.springsecurity.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store = new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Rashid Makki","rashid@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"A Makki","a@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"B Makki","b@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"C Makki","c@gmail.com"));
    }

    public  List<User> findAllUsers(){
        return this.store;
    }
}
