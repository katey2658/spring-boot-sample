package com.busyzero.demo.netty.http;

public class Application {
    public static void main(String[] args) throws Exception {
        HttpServer server = new HttpServer(8080);
        server.start();
    }
}
