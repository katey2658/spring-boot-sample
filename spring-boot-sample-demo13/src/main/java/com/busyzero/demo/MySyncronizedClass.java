package com.busyzero.demo;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/9 9:25 下午
 */
public class MySyncronizedClass {

    public synchronized void a() {
        System.out.println("进入 a " + Thread.currentThread().getName());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("退出 a " + Thread.currentThread().getName());
    }

    public synchronized void b() {
        System.out.println("进入 b " + Thread.currentThread().getName());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("退出 b " + Thread.currentThread().getName());
    }
}
