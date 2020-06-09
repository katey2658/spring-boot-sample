package com.busyzero.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 9:54 下午
 */
@Configuration
public class DelegationHelloWorldConfiguration {

    @Bean
    public  String helloWorld() {
        return "Hello, World";
    }
}
