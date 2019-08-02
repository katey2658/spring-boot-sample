package com.busyzero.demo.v11;

public interface WebServer {
    void start() throws RuntimeException;

    void stop() throws RuntimeException;

    int getPort();

}
