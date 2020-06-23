package com.busyzero.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.security.CodeSource;
import java.security.ProtectionDomain;

@RestController
@SpringBootApplication
public class App {

    @RequestMapping("/")
    private String index() {
        return "My Dear";
    }
    public static void main(String[] args) {
        try {
            StackTraceElement[] elements = (new RuntimeException()).getStackTrace();
            Class clazz = App.class;
            for (StackTraceElement element : elements) {
                System.out.println("x" + element.getClassName() + "#" + element.getMethodName());
                if (!element.getClassName().equals(App.class.getName()) && element.getMethodName().equals("main")) {
                    System.out.println(element.getClassName());
                    clazz = Class.forName(element.getClassName()) ;
                    continue;
                }
            }
            ProtectionDomain protectionDomain = clazz.getProtectionDomain();
            CodeSource codeSource = protectionDomain.getCodeSource();
            URI location = (codeSource != null ? codeSource.getLocation().toURI() : null);
            String path = (location != null ? location.getSchemeSpecificPart() : null);
            System.out.println("---- " + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SpringApplication.run(App.class, args);
    }
}
