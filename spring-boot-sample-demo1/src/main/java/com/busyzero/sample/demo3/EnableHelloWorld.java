package com.busyzero.sample.demo3;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(HelloWordConfiguration.class)
public @interface EnableHelloWorld {
}
