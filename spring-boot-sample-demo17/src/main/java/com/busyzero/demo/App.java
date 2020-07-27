package com.busyzero.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
//public class App
//{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
//}

@RestController
@SpringBootApplication
public class App {

    @GetMapping
    public String helloWorld() {
        return "helloWorld";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
