package com.busyzero.demo.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


@SpringBootApplication
@EnableCircuitBreaker
public class SpringApplicationHystrix {

    public static void main(String[] args) {
       SpringApplication.run(SpringApplicationHystrix.class, args);
    }
}
