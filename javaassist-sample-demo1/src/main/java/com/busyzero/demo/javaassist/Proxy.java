package com.busyzero.demo.javaassist;

public class Proxy {

    public static <T> T getBean(Class<T> iface) {
        Invoker invoker = new RandomCluster();
        InvocationHandler handler = new InvocationHandler(invoker);

        T proxyInstance = null;
        try {
            proxyInstance = (T) ProxyGenerator.newProxyInstance(null, iface, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proxyInstance;
    }
}
