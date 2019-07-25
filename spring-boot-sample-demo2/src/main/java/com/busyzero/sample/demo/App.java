package com.busyzero.sample.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Hello world!
 */
//@RestController
@SpringBootApplication
public class App {

//    @RequestMapping("/")
//    public String index(){
//        return "Hello Json";
//    }


    public static void main(String[] args) {
//        new SpringApplicationBuilder(App.class).bannerMode(Banner.Mode.OFF).run(args);
//        ConfigurableApplicationContext context  = SpringApplication.run(App.class, args);
//        AnnotationMBeanExporter exporter = context.getBean(AnnotationMBeanExporter.class);
//        System.out.println(exporter);
//        context.close();

        SpringApplication application = new SpringApplication(App.class);
        application.setAddCommandLineProperties(true);
//          application.setAdditionalProfiles();
//        application.setApplicationContextClass(null);
        application.setBanner(null);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.setBeanNameGenerator(null);
//        application.setDefaultProperties(null);
        application.setEnvironment(null);
        application.setHeadless(true);
//        application.setInitializers();
//        application.addInitializers();
//        application.setListeners();
//        application.addListeners();
        application.setLogStartupInfo(true);
//        application.setMainApplicationClass();
        application.setRegisterShutdownHook(true);
//        application.setResourceLoader(Thread.currentThread().getContextClassLoader());
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.setSources();
//        application.addPrimarySources();
        application.run(args);
    }
//
//    @Bean
//    public RouterFunction<ServerResponse> hello() {
//        return route(GET("/hello-world"), request -> ok().body(Mono.just("Hello "), String.class));
//    }

//    @Bean
//    public ApplicationRunner runner(WebServerApplicationContext context) {
//        return args -> {
//            System.out.println(context.getWebServer().getClass().getName());
//        };
//    }

//    @EventListener(WebServerInitializedEvent.class)
//    public void onWebServerReady(WebServerInitializedEvent event) {
//        System.out.println(event.getWebServer().getClass().getName());
//    }
}
