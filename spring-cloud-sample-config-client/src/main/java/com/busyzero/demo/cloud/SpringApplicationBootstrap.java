package com.busyzero.demo.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
       SpringApplication.run(SpringApplicationBootstrap.class, args);
    }

    @Bean
    public CommandLineRunner  myCommandLineRunner() {
        return args -> System.out.println("CommandLineRunner" + args.toString());
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> System.out.println("ApplicationRunner:"  + args.toString());
    }


    @Value("${name}")
    private String configName;

    @GetMapping("/name")
    public String getName() {
         return configName;
    }
}
