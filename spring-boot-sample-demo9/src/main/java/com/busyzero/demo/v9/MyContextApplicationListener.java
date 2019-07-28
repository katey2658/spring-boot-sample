package com.busyzero.demo.v9;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class MyContextApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            System.out.println("ContextRefreshedEvent : " + event.toString());
        }

        if (event instanceof ContextStartedEvent) {
            System.out.println("ContextStartedEvent : " + event.toString());
        }
        if (event instanceof ContextStoppedEvent) {
            System.out.println("ContextStoppedEvent : " + event.toString());
        }
        if (event instanceof ContextClosedEvent) {
            System.out.println("ContextRefreshedEvent : " + event.toString());
        }
    }
}
