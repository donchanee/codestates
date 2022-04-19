package com.codestates.bta;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
public class Handlers {
    public Mono<ServerResponse> helloHandler(ServerRequest request) {
        String name = request.queryParam("name").orElse("User");

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Models(name, "Hello " + name)));
    }
}