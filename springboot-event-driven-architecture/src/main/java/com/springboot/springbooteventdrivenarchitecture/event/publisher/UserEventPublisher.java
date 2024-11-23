package com.springboot.springbooteventdrivenarchitecture.event.publisher;

import com.springboot.springbooteventdrivenarchitecture.event.eventcreation.UserCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public UserEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishUserCreatedEvent(String userName) {
        UserCreatedEvent event = new UserCreatedEvent(this, userName);
        eventPublisher.publishEvent(event);
    }
}

