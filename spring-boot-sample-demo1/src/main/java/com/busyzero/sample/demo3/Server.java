package com.busyzero.sample.demo3;

public interface Server {
    void start();

    void stop();

    enum Type{
        HTTP,
        FTP
    }
}
