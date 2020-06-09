package com.busyzero.demo;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 10:28 下午
 */
public interface Server {
    void start();
    void stop();

    enum Type {
        HTTP,
        FTP
    }
}
