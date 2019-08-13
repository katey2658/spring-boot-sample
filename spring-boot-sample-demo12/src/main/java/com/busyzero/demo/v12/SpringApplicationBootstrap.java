package com.busyzero.demo.v12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;


@SpringBootApplication
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationBootstrap.class, args);
        try{
            System.in.read();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean(initMethod = "start")
    public BenzCar benzCar(Engine engine) {
        BenzCar car = new BenzCar();
        car.engine = engine;
         return car;
    }

    @Bean
    public SpecialBeanForEngine specialBeanForEngine() {
        return new SpecialBeanForEngine();
    }
}
