package com.busyzero;

import com.busyzero.iface.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String val1) {
        System.out.println("Server receive :" + val1);
        return "hello " + val1 + "!";
    }
}
