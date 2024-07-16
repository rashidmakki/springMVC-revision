package com.springboot.springbootkeycloak.config;

import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.server.resource.authentication.JwtBearerTokenAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .requestMatchers("/*").authenticated()
            .requestMatchers("/public/*","/login").permitAll()
            .anyRequest().authenticated();
//        http.oauth2Login(oauth2Login ->
//            oauth2Login.userInfoEndpoint(userInfoEndpoint ->
//                    userInfoEndpoint.oidcUserService(this.oidcUserService())
//            )
//        );
//        http.oauth2ResourceServer(oauth2ResourceServer ->
//            oauth2ResourceServer.jwt(jwt ->
//                    jwt.jwtAuthenticationConverter(new JwtBearerTokenAuthenticationConverter())
//            )
//        );
        return http.build();
    }

//    private OidcUserService oidcUserService() {
//        OidcUserService delegate = new OidcUserService();
//        return (userRequest) -> {
//            OidcUser oidcUser = delegate.loadUser(userRequest);
//            return oidcUser;
//        };
//    }
}

