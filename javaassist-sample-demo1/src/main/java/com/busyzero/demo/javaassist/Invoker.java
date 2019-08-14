package com.busyzero.demo.javaassist;

public interface Invoker<T> extends Node {
    Class<T>  getInterface();

    Result invoke(Invocation invocation) throws RpcException;
}
