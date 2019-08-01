package com.busyzero.demo.v11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KrAutoConfiguration {

    @Bean
    public TwoBean twoBean() {
        return new TwoBean();
    }

}
