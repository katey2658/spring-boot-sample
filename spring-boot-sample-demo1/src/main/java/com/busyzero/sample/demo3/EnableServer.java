package com.busyzero.sample.demo3;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(ServerImportSelector.class)
@Import(ServerImportBeanDefinitionsRegistrar.class)
public @interface EnableServer {
    Server.Type type();
}
