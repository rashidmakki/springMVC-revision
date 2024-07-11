package com.gateway.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static final List<String> openApiEndpoints = List.of(
            "/auth/signup",
            "/auth/login",
            "/eureka",
            "/user-service/api-docs",
            "/hotel-service/api-docs",
            "/rating-service/api-docs",
            "/auth-service/api-docs"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch( uri -> request.getURI().getPath().contains(uri));
}
