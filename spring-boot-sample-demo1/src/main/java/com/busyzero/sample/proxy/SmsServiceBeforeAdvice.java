package com.busyzero.sample.proxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SmsServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before ....");
    }
}
