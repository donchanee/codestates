package com.codestates.week2ass1.handlers;


import com.codestates.week2ass1.models.Models;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;


@Component
public class Handlers {

    static WebClient webClient  = WebClient.create("http://localhost:8081");

    public static Mono<ServerResponse> helloHandler(ServerRequest req) {
        String name = req.queryParam("name").orElse("User");

        Mono<Map> callInfoService = webClient.get()
                .uri("/job?name=" + name)
                .retrieve()
                .bodyToMono(Map.class);

        Mono<Models> modelData = callInfoService.map(
                map -> new Models(name, (String) map.get("job"), "Hello "+ name)
        );

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(modelData, Models.class);
    }
}