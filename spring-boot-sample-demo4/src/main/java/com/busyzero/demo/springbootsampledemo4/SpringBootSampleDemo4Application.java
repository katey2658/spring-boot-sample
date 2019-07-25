package com.busyzero.demo.springbootsampledemo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootSampleDemo4Application {


	public static void main(String[] args) {
		
		// start embedded zookeeper server
		new EmbeddedZooKeeper(2181, false).start();

		SpringApplication.run(SpringBootSampleDemo4Application.class, args);
//		SpringApplication application = new SpringApplicationBuilder(SpringBootSampleDemo4Application.class).bannerMode(Banner.Mode.CONSOLE).build();
//		Set<ApplicationListener<?>> listenerSet = application.getListeners();
//		listene
//
//		rSet.removeIf(item -> item instanceof WelcomeLogoApplicationListener);
//		application.run(args);
	}
	
}
