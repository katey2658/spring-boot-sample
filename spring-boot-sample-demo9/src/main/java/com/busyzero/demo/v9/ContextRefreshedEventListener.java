package com.busyzero.demo.v9;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    private final long id;

    public ContextRefreshedEventListener() {
        this.id = System.nanoTime();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.printf("ContextRefreshedEvent[id: %d] 接受到的事件:%s \n", id, event.getClass().getSimpleName());
    }

    @Override
    public int hashCode() {
        return (int)System.nanoTime();
    }
}
