package com.busyzero.demo.javaassist;

public interface Exporter<T> {
    Invoker<T> getInvoker();
    void unexport();
}
