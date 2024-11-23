package com.springboot.springbooteventdrivenarchitecture.controller;

import com.springboot.springbooteventdrivenarchitecture.event.publisher.UserEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserEventPublisher userEventPublisher;

    @PostMapping("/create")
    public String createUser(@RequestParam String name) {
        userEventPublisher.publishUserCreatedEvent(name);
        return "User creation event published for: " + name;
    }
}

