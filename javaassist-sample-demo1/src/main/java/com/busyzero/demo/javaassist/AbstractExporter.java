package com.busyzero.demo.javaassist;

public class AbstractExporter<T> implements Exporter<T> {
    private volatile boolean unexported = false;
    private final Invoker<T> invoker;

    public AbstractExporter(Invoker<T> invoker) {
        this.invoker = invoker;
    }

    @Override
    public Invoker<T> getInvoker() {
        return invoker;
    }

    @Override
    public void unexport() {
        if (unexported) {
            return;
        }
        unexported = true;
        getInvoker().destroy();
    }
}
