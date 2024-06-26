package com.security.jwt.springsecuritywithdb.service;

import com.security.jwt.springsecuritywithdb.model.User;
import com.security.jwt.springsecuritywithdb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityCustomUserDetailService implements UserDetailsService {
     @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

    public List<User> findAllUser() {
        return this.userRepository.findAll();
    }
}
