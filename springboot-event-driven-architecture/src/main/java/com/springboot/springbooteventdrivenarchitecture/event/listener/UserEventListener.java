package com.springboot.springbooteventdrivenarchitecture.event.listener;

import com.springboot.springbooteventdrivenarchitecture.entity.User;
import com.springboot.springbooteventdrivenarchitecture.event.eventcreation.UserCreatedEvent;
import com.springboot.springbooteventdrivenarchitecture.repository.UserRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventListener {

    private final UserRepository userRepository;

    public UserEventListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener
    public void handleUserCreatedEvent(UserCreatedEvent event) {
        User user = new User();
        user.setName(event.getUserName());
        userRepository.save(user);
        System.out.println("User saved: " + user.getName());
    }
}

