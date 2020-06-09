package com.busyzero.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/5/31 8:34 下午
 */
@EnableHelloWorld
@EnableAutoConfiguration
public class WebConfiguration {
    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return route(GET("/hello"), request -> ServerResponse.ok().body(Mono.just(" Me, katey2658") , String.class));
    }

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("当前 WebServer 实现类为：" + event.getWebServer().getClass().getName());
    }
}
