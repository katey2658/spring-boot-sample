package com.busyzero.demo.v9;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;


@SpringBootApplication
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApplicationBootstrap.class, args);
        context.addApplicationListener(new MyContextApplicationListener());
        context.publishEvent(new ApplicationEvent("this is a customize  event"){});
        AnnotationMBeanExporter  beanExporter = context.getBean(AnnotationMBeanExporter.class);
        System.out.println("Bean :" + beanExporter);
        context.close();
    }

    @Bean
    public CommandLineRunner  myCommandLineRunner() {
        return args -> System.out.println("CommandLineRunner" + args.toString());
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> System.out.println("ApplicationRunner:"  + args.toString());
    }
}
