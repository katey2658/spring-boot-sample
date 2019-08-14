package com.busyzero.demo.javaassist;

public interface Node {
    URL getUrl();

    boolean isAvailable();

    void destroy();
}
