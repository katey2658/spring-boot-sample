package com.busyzero.demo.v11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
public class MyAuthConfiguration {

    @Bean
    public OneBean oneBean() {
        return new OneBean();
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer(Environment environment){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setEnvironment(environment);
        return configurer;
    }
}
