package com.busyzero.demo;

import org.springframework.stereotype.Component;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 10:30 下午
 */
@Component
public class HttpServer implements Server{

    @Override
    public void start() {
        System.out.println(" Http 服务器启动中 ...");
    }

    @Override
    public void stop() {
        System.out.println(" Http 服务器关闭中 ...");
    }
}
