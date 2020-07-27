package com.busyzero.demo.v14.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class WebConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "me.datasource.first", ignoreInvalidFields = true)
    public MeDataSourceConfigurationsProperties firstProperties(){
        return new MeDataSourceConfigurationsProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "me.datasource.second", ignoreInvalidFields = true)
    public MeDataSourceConfigurationsProperties secondProperties(){
        return new MeDataSourceConfigurationsProperties();
    }

    @Bean
    public RouterFunction<ServerResponse> sayMe(MeDataSourceConfigurationsProperties properties) {
        return route(GET("/sayme"), request -> ServerResponse.ok().body(Mono.just(properties.getHost()), String.class));
    }
}
