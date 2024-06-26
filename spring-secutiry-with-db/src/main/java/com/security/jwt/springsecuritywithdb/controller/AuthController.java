package com.security.jwt.springsecuritywithdb.controller;

import com.security.jwt.springsecuritywithdb.model.JwtRequest;
import com.security.jwt.springsecuritywithdb.model.JwtResponse;
import com.security.jwt.springsecuritywithdb.model.User;
import com.security.jwt.springsecuritywithdb.security.JwtHelper;
import com.security.jwt.springsecuritywithdb.service.SecurityCustomUserDetailService;
import com.security.jwt.springsecuritywithdb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private SecurityCustomUserDetailService securityCustomUserDetailService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserService userService;


    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> signup(@RequestBody User userRequest) {

        User user = userService.findUserByEmail(userRequest.getEmail());
        if( user != null){
            throw new BadCredentialsException("Email already in use");
        }
        userService.saveUser(userRequest);
        UserDetails userDetails = securityCustomUserDetailService.loadUserByUsername(userRequest.getEmail());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        this.doAuthenticate(request.getEmail(), request.getPassword());

        UserDetails userDetails = securityCustomUserDetailService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
}
