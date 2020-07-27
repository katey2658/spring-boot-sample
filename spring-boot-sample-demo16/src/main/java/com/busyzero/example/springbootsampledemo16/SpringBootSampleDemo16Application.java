package com.busyzero.example.springbootsampledemo16;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootSampleDemo16Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleDemo16Application.class, args);

//		SpringApplication app = new SpringApplicationBuilder(SpringBootSampleDemo16Application.class)
//				.web(WebApplicationType.SERVLET)
//				.bannerMode(Banner.Mode.CONSOLE)
//				.build(args);
//		app.run();
	}

}
