package com.security.jwt.springsecuritywithdb.controller;

import com.security.jwt.springsecuritywithdb.model.User;
import com.security.jwt.springsecuritywithdb.service.SecurityCustomUserDetailService;
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
    private SecurityCustomUserDetailService securityCustomUserDetailService;

    @RequestMapping("/users")
    public List<User> getAllUser() {
        this.logger.warn("getting users");
        return this.securityCustomUserDetailService.findAllUser();
    }

    @RequestMapping("/currentuser")
    public String getLoggedInUser(Principal principal) {
        return principal.getName();
    }
}