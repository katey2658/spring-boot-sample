package com.busyzero.sample.proxy;

public class SmsServiceImpl implements SmsService{

    @Override
    public void send() {
        System.out.println("send ---- ");
    }

    @Override
    public String query() {
        System.out.println("query ---- ");
        return "query result";
    }

    @Override
    public int reSend() {
        System.out.println("reSend ---- ");
        return 0;
    }
}
