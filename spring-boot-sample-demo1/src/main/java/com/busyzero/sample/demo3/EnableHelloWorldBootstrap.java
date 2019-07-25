package com.busyzero.sample.demo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHelloWorld
public class EnableHelloWorldBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext();
        context.register(EnableHelloWorldBootstrap.class); // 注册引导类
        context.refresh();
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.printf("helloWorld = %s \n", helloWorld);
        context.close();
    }
}
