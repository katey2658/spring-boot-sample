package com.busyzero.demo.javaassist;

public class Proxy {

    public static <T> T getProxy(Class<?>[] ifaces) {
        RandomCluster cluster = new RandomCluster(ifaces[0]);
        Invoker invoker = cluster.join();
        InvocationHandler handler = new InvocationHandler(invoker);
        T proxyInstance = null;
        try {
            proxyInstance = (T) ProxyGenerator.newInstance(null).newProxyInstance(ifaces, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proxyInstance;
    }
}
