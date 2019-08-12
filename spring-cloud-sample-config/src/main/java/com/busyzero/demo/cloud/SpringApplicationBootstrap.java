package com.busyzero.demo.cloud;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigServer
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
}
