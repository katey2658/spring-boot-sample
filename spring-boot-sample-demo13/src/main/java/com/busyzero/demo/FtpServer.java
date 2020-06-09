package com.busyzero.demo;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 10:31 下午
 */
public class FtpServer implements Server{

    @Override
    public void start() {
        System.out.println(" FTP 服务器启动中 ...");
    }

    @Override
    public void stop() {
        System.out.println(" FTP 服务器关闭中 ...");
    }
}
