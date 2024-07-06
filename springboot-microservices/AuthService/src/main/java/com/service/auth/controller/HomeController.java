package com.service.auth.controller;

import  com.service.auth.model.User;
import  com.service.auth.service.SecurityCustomUserDetailService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
@SecurityRequirement(name = "Authorization")
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private SecurityCustomUserDetailService securityCustomUserDetailService;

    @GetMapping("/users")
    public List<User> getAllUser() {
        this.logger.warn("getting users");
        return this.securityCustomUserDetailService.findAllUser();
    }

    @GetMapping("/currentuser")
    public String getLoggedInUser(Principal principal) {
        return principal.getName();
    }
}