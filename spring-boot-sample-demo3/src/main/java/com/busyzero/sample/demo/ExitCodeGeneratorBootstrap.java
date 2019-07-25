package com.busyzero.sample.demo;

import org.springframework.boot.ExitCodeEvent;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class ExitCodeGeneratorBootstrap {
    public static void main(String[] args) {
        int exit = SpringApplication.exit(new SpringApplicationBuilder(ExitCodeGeneratorBootstrap.class)
                .listeners((ApplicationListener<ExitCodeEvent>)event -> System.out.println("监听到退出码" + event.getExitCode())).web(false).run(args));

        System.exit(exit);
    }


    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
        System.out.println("ExitCodeGenerator bean 创建");
        return () -> {
            System.out.println("执行退出码（88）");
            return 88;
        };
    }
}
