package com.busyzero.demo.v6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

@Configuration
@ComponentScan(basePackageClasses = CalculatingServiceBootstrap.class)
public class CalculatingServiceBootstrap {

    static {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "Java7");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CalculatingServiceBootstrap.class);
        context.refresh();
        CalculatingService calculatingService = context.getBean(CalculatingService.class);
        calculatingService.sum(1, 2, 3, 4, 5);
        context.close();
    }
}
