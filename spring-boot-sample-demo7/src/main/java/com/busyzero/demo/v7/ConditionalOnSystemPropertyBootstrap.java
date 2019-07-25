package com.busyzero.demo.springbootsampledemo4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalOnSystemPropertyBootstrap {
    static {
        System.setProperty("language", "Chinese");
        System.setProperty("language", "English");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConditionalMessageConfiguration.class);
        context.refresh();
        String message = context.getBean("message", String.class);
        System.out.println(message);
    }
}
