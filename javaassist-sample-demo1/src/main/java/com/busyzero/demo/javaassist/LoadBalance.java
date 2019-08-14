package com.busyzero.demo.javaassist;

import java.util.List;

public interface LoadBalance{
    Invoker select(List<Invoker> invokers, URL url, Invocation  invocation);
}
