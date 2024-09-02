package com.springboot.springbootkeycloak.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private KeycloakJwtTokenConverter keycloakJwtTokenConverter;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
            .cors(cor -> cor.disable())
            .csrf(csrf -> csrf.disable())
            .authorizeRequests()
            .requestMatchers("/*").authenticated()
            .requestMatchers("/public/*","/login").permitAll()
            .anyRequest().authenticated();
//        http.oauth2Login(oauth2Login ->
//            oauth2Login.userInfoEndpoint(userInfoEndpoint ->
//                    userInfoEndpoint.oidcUserService(this.oidcUserService())
//            )
//        );

        http.oauth2ResourceServer(oauth2ResourceServer ->
            oauth2ResourceServer.jwt(jwt ->
                    jwt.jwtAuthenticationConverter(keycloakJwtTokenConverter)
            )
        );

        http.sessionManagement(
                sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        return http.build();
    }
}

