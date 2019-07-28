package com.busyzero.demo.v9;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

public class MyApplicationEventPublisher implements ApplicationEventPublisher {
    @Override
    public void publishEvent(Object event){
        System.out.println("publishEvent Object" + event.getClass());
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        System.out.println("publishEvent ApplicationEvent" + event.getClass());
    }
}
