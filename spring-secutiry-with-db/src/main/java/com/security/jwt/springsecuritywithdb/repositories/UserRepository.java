package com.security.jwt.springsecuritywithdb.repositories;

import com.security.jwt.springsecuritywithdb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public User findByEmail(String email);
}
