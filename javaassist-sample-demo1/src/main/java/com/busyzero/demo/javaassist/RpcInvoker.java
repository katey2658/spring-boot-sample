package com.busyzero.demo.javaassist;

import java.util.concurrent.ThreadLocalRandom;

public class RpcInvoker<T> implements Invoker<T> {
    private String name;
    private Class<T> iface;

    @Override
    public Class getInterface() {
        return iface.getClass();
    }

    public void setIface(Class<T> iface) {
        this.iface = iface;
    }

    @Override
    public Result invoke(Invocation invocation) throws RpcException {
        String name = invocation.getMethodName();
        Result result = new Result();
        result.setData(this.name + ": 你调用了" + name);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public URL getUrl() {
        URL url = new URL();
        url.setWeight(ThreadLocalRandom.current().nextInt(1000));
        return url;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void destroy() {

    }
}
