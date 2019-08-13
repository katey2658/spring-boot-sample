package com.busyzero.demo.javaassist;

public interface Invoker {
    Result invoke(Invocation invocation) throws RpcException;
}
