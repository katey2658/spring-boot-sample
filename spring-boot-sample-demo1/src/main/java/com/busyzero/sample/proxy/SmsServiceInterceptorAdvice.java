package com.busyzero.sample.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SmsServiceInterceptorAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("AROUND_ADVICE:BEFORE");
        Object returnValue = invocation.proceed();
        System.out.println("AROUND_ADVICE:AFTER");
        return returnValue;
    }
}
