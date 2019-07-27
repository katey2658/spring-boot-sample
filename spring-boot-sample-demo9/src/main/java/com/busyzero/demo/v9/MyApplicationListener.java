package com.busyzero.demo.v9;

import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationStartingEvent) {
            ApplicationStartingEvent startingEvent = (ApplicationStartingEvent) event;
            System.out.println("ApplicationStartingEvent :" + startingEvent.getArgs());
            return;
        }
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            System.out.println("ApplicationEnvironmentPreparedEvent :" + preparedEvent.getArgs());
            return;
        }
        if (event instanceof ApplicationPreparedEvent) {
            ApplicationPreparedEvent preparedEvent = (ApplicationPreparedEvent) event;
            System.out.println("ApplicationPreparedEvent :" + preparedEvent.getArgs());
            return;
        }
        if (event instanceof ApplicationStartedEvent) {
            ApplicationStartedEvent startedEvent= (ApplicationStartedEvent) event;
            System.out.println("ApplicationStartedEvent :" + startedEvent.getArgs());
            return;
        }
        if (event instanceof ApplicationReadyEvent) {
            ApplicationReadyEvent readyEvent = (ApplicationReadyEvent) event;
            System.out.println("ApplicationReadyEvent :" + readyEvent.getArgs());
            return;
        }
        if (event instanceof ApplicationFailedEvent) {
            ApplicationFailedEvent failedEvent = (ApplicationFailedEvent) event;
            System.out.println("ApplicationFailedEvent :" + failedEvent.getArgs());
            return;
        }
        System.out.println(event.getSource());
    }
}
