package com.busyzero.demo.v14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//@RestController
//@SpringBootApplication
public class App {

    private static final List<byte[]> LIST = new ArrayList<>();
    private static final ReferenceQueue RQ = new ReferenceQueue();
    public static void main(String[] args) throws InterruptedException {
//        SpringApplication.run(App.class, args);
//        MBean mBean = new MBean();
//        try {
//            mBean.finalize();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        mBean = null;
//        System.gc();
//
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SoftReference<byte[]> sr = new SoftReference<>(new byte[1024 * 1024 * 10]);
//        System.out.println(sr.get());
//
//        Thread.sleep(500);
//
//        System.out.println(sr.get());
//        byte[] b = new  byte[1024 * 1024 * 10];
//        System.out.println(sr.get());

//        WeakReference<byte[]> sr = new WeakReference<>(new byte[1024 * 1024 * 10]);
//        System.gc();
//        System.out.println(sr.get());

        PhantomReference<MBean> pr = new PhantomReference<MBean>(new MBean(), RQ);

        new Thread(() -> {
            while (true) {
                LIST.add(new byte[1024 * 1024]);
                 try {
                     Thread.sleep(500);
                 } catch (InterruptedException e) {
                     System.out.println(e.getMessage());
                 }

            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference<? extends MBean> poll = RQ.poll();
                if (poll != null) {
                    System.out.println(" phantom " + poll);
                }
            }
        }).start();

        Thread.sleep(5000);
    }

    public static class MBean {
        @Override
        protected void finalize() throws Throwable {
//            mBean = this;
            System.out.println("finalize");
        }
    }
}
