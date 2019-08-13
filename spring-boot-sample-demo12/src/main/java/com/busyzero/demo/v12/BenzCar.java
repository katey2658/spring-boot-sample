package com.busyzero.demo.v12;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class BenzCar implements InitializingBean {

    Engine engine;

    public BenzCar() {
        System.out.println("BenzCar Constructor");
        if (engine == null) {
            System.out.println("BenzCar's engine not setting");
        } else {
            System.out.println("BenzCar's engine installed");
        }
    }

    void start() {
        System.out.println("BenzCar start");
        engine.fire();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BenzCar afterPropertiesSet");
        if (engine == null) {
            System.out.println("BenzCar's engine not setting, in afterPropertiesSet");
        } else {
            System.out.println("BenzCar's engine installed, in afterPropertiesSet");
        }
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("BenzCar postConstruct");
        if (engine == null) {
            System.out.println("BenzCar's engine not setting, in postConstruct");
        } else {
            System.out.println("BenzCar's engine installed, in postConstruct");
        }
    }
}
