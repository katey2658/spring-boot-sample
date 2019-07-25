package com.busyzero.sample.demo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWordConfiguration {

     @Bean
     public String helloWorld(){
         return "HelloWord";
     }
}
