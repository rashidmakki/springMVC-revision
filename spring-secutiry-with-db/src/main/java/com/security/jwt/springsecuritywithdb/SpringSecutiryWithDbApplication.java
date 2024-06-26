package com.security.jwt.springsecuritywithdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.security.jwt.springsecuritywithdb")
public class SpringSecutiryWithDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecutiryWithDbApplication.class, args);
    }

}
