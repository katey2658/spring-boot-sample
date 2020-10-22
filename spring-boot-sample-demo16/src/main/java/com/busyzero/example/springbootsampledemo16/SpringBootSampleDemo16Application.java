package com.busyzero.example.springbootsampledemo16;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc
//@Configuration
public class SpringBootSampleDemo16Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleDemo16Application.class, args);

//		SpringApplication app = new SpringApplicationBuilder(SpringBootSampleDemo16Application.class)
//				.web(WebApplicationType.SERVLET)
//				.bannerMode(Banner.Mode.OFF)
//				.build(args);
//		ConfigurableApplicationContext applicationContext = app.run();

//		 new SpringApplication(SpringBootSampleDemo16Application.class).run(args);
	}


//	class NewMyApp extends AbstractDispatcherServletInitializer {
//
//		@Override
//		protected WebApplicationContext createServletApplicationContext() {
//			return null;
//		}
//
//		@Override
//		protected String[] getServletMappings() {
//			return new String[0];
//		}
//
//		@Override
//		protected WebApplicationContext createRootApplicationContext() {
//			return null;
//		}
//	}

}



