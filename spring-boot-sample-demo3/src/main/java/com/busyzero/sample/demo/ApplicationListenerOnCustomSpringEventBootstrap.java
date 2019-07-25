package com.busyzero.sample.demo;

import org.springframework.context.support.GenericApplicationContext;

public class ApplicationListenerOnCustomSpringEventBootstrap {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(MyApplicationListener.class);
        context.refresh();
        context.publishEvent(new MyApplicationEvent("Hello Dong!"));
        context.close();
        context.publishEvent(new MyApplicationEvent("Say Hello Again!"));
    }
}


