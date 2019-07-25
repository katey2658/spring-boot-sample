package com.busyzero.sample.demo3;

public class HttpServer implements  Server{

    @Override
    public void start() {
        System.out.println("Http 服务器启动中...");
    }

    @Override
    public void stop() {
        System.out.println("Http 服务器关闭中 ...");
    }
}
