package com.busyzero.demo.v11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAuthConfiguration {

    @Bean
    public OneBean oneBean() {
        return new OneBean();
    }
}
