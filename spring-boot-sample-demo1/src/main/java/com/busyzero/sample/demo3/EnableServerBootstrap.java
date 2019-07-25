package com.busyzero.sample.demo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableServer(type = Server.Type.FTP)
public class EnableServerBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableServerBootstrap.class);
        context.refresh();
        Server server = context.getBean(Server.class);
        server.start();
        server.stop();
    }
}
