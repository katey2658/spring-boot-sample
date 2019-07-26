package com.busyzero.demo.v9;

import org.springframework.boot.SpringBootExceptionReporter;
import org.springframework.context.ConfigurableApplicationContext;

public class MySpringBootExceptionReporter implements SpringBootExceptionReporter {

    public MySpringBootExceptionReporter(ConfigurableApplicationContext context) {
    }

    @Override
    public boolean reportException(Throwable failure) {
        System.out.println(failure.getMessage());
        return false;
    }
}
