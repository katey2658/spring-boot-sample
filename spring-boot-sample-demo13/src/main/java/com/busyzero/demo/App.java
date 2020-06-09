package com.busyzero.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//@SpringBootApplication
//@Configuration
//@EnableHelloWorld
//@EnableServer(type = Server.Type.FTP)
public class App {
//
//    @RequestMapping("/")
//    private String index() {
//        return "My Dear";
//    }
    public static void main(String[] args) {
//        SpringApplication.run(WebConfiguration.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(App.class);
//        context.refresh();
//
//        Server server = context.getBean(Server.class);
//        server.start();
//        server.stop();
//        context.close();

        MySyncronizedClass syncronizedClass = new MySyncronizedClass();
        new Thread(() -> {
            syncronizedClass.a();
        }).start();

        new Thread(() -> {
            syncronizedClass.b();
        }).start();
    }
}
