package com.busyzero.demo.zuul.strategy;


import com.busyzero.demo.stream.utils.UserContextHolder;
import com.busyzero.demo.stream.vo.UserContext;

import java.util.concurrent.Callable;

public final class DelegatingUserContextCallable<V> implements Callable<V>{
    private final Callable<V> delegate;
    private UserContext originalUserContext;
    public DelegatingUserContextCallable(Callable<V> callable, UserContext userContext) {
        this.delegate  = callable;
        this.originalUserContext = userContext;
    }

    @Override
    public V call() throws Exception {
        UserContextHolder.setContext(originalUserContext);
        try {
            return delegate.call();
        } finally {
            this.originalUserContext = null;
        }
    }

    public static <V> Callable<V> create(Callable<V> delegate, UserContext userContext) {
        return new DelegatingUserContextCallable<>(delegate, userContext);
    }
}
