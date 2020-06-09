package com.busyzero.demo.v14.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class WebConfiguration {

    @Bean
    public RouterFunction<ServerResponse> sayMe() {
        return route(GET("/sayme"), request -> ServerResponse.ok().body(Mono.just("say me"), String.class));
    }
}
