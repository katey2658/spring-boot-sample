package com.busyzero.demo.springbootsampledemo4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalMessageConfiguration {

    @ConditionOnSystemProperty(name = "language", value = "Chinese")
    @Bean("message")
    public String chineseMessage() {
        return "你好， 世界";
    }

    @ConditionOnSystemProperty(name= "language", value = "English")
    @Bean("message")
    public String engliseMessage(){
        return "Hello, World";
    }
}
