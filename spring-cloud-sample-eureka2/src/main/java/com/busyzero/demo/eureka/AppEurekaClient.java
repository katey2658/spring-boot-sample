package com.busyzero.demo.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppEurekaClient {
    public static void main(String[] args) {
        SpringApplication.run(AppEurekaClient.class, args);
    }
}
