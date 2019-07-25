package com.busyzero.sample.demo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DerivedComponentAnnotationBootstrap {
    static {
        System.setProperty("java.version", "1.8.0");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("classpath:application.xml");

        context.refresh();

        NameRepository repository = (NameRepository) context.getBean("chineseNameRepository");

        System.out.printf("nameRepository.findAll() = %s \n", repository.findAll());

    }
}
