package com.busyzero.sample.demo3;

public class FtpServer implements  Server {

    @Override
    public void start() {
        System.out.println("Ftp 服务器启动中...");
    }

    @Override
    public void stop() {
        System.out.println("Ftp 服务器关闭中...");
    }
}
