package com.busyzero.sample.proxy;

import org.springframework.aop.framework.ProxyFactoryBean;

public class ProxtApp {

    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setInterfaces(SmsService.class);
        proxyFactoryBean.setTarget(smsService);
        proxyFactoryBean.setProxyTargetClass(true);

        proxyFactoryBean.addAdvice(new SmsServiceBeforeAdvice());
        proxyFactoryBean.addAdvice(new SmsServiceAfterReturningAdvice());
        proxyFactoryBean.addAdvice(new SmsServiceInterceptorAdvice());
        proxyFactoryBean.addAdvice(new SmsServiceThrowsAdvice());

        smsService = (SmsService) proxyFactoryBean.getObject();
        smsService.send();
        smsService.query();
        smsService.reSend();
    }
}
