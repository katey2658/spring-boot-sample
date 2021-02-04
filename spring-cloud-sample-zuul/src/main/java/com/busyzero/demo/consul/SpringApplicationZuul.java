package com.busyzero.demo.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy
public class SpringApplicationZuul {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationZuul.class, args);
    }
}
