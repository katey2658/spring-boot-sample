package com.busyzero.demo.v8;

import com.busyzero.demo.formatter.Formatter;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

@EnableAutoConfiguration
public class FormatterBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FormatterBootstrap.class).web(WebApplicationType.NONE).run(args);
        Map<String, Object> data = new HashMap<>();
        data.put("name", "东东");
        Formatter  formatter = context.getBean(Formatter.class);
        System.out.printf("%s.format(data) : %s\n", formatter.getClass().getSimpleName(), formatter.format(data));
        context.close();
    }
}
