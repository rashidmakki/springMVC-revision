package com.jwt.springsecurity.controller;

import com.jwt.springsecurity.model.User;
import com.jwt.springsecurity.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUser() {
        this.logger.warn("getting users");
        return this.userService.findAllUsers();
    }

    @RequestMapping("/currentuser")
    public String getLoggedInUser(Principal principal) {
        return principal.getName();
    }
}