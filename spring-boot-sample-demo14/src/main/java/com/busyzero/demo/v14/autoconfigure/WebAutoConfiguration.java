package com.busyzero.demo.v14.autoconfigure;

import com.busyzero.demo.v14.config.WebConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {
}
