package com.busyzero.demo.javaassist;

import java.util.List;

public abstract class AbstractLoadBalance implements LoadBalance {
    @Override
    public Invoker select(List<Invoker> invokers, URL url, Invocation invocation) {
        if (invokers == null || invokers.isEmpty()) {
            return null;
        }

        if (invokers.size() == 1) {
            return invokers.get(0);
        }
        return doSelect(invokers, url, invocation);
    }

    protected int  getWeight(Invoker invoker, Invocation invocation) {
        return invoker.getUrl().getWeight();
    }

    protected abstract Invoker doSelect(List<Invoker> invokers, URL url, Invocation invocation);
}
