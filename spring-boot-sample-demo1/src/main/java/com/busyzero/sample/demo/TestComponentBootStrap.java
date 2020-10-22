package com.busyzero.sample.demo;

        import org.springframework.boot.WebApplicationType;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.builder.SpringApplicationBuilder;
        import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication
public class TestComponentBootStrap {

    public static void main(String[] args) {
        Class<?> bootstrapClass = TestComponentBootStrap.class;
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(bootstrapClass)
                .web(WebApplicationType.NONE)
                .run();
        System.out.println("当前引导类 Bean:" + applicationContext.getBean(bootstrapClass));
        applicationContext.close();
    }
}
