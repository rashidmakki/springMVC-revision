package com.security.jwt.springsecuritywithdb.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "USER")
public class User implements UserDetails {
    @Id
    private String userId;
    private String email;
    private String password;
    private boolean enabled = true;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Collection of SimpleGrantedAuthorities
        Collection<SimpleGrantedAuthority> roleList =  roles.stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
        return roleList;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

}
