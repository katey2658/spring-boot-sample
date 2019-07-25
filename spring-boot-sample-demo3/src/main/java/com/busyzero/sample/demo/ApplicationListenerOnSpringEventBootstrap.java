package com.busyzero.sample.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ApplicationListenerOnSpringEventBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new GenericApplicationContext();
        System.out.println("创建Spring上下文："  + context.getDisplayName());

        context.addApplicationListener(event -> System.out.println("触发事件：" + event.getClass().getSimpleName()));
        System.out.println("上下文准备初始化");
        context.refresh();
        System.out.println("上下文准备初始化");


        System.out.println("上下文准备停止");
        context.stop();
        System.out.println("上下文已经停止");

        System.out.println("上下文准备启动");
        context.start();
        System.out.println("上下文已经启动");

        System.out.println("上下文准备关闭");
        context.close();
        System.out.println("上下文已经关闭");
    }
}
