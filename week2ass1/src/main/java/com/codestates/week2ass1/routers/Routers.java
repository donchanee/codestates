package com.codestates.week2ass1.routers;

import com.codestates.week2ass1.handlers.Handlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class Routers {

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions.route(GET("/hello")
                .and(accept(MediaType.APPLICATION_JSON)), Handlers::helloHandler);
    }
}