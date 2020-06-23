package com.busyzero.demo.v15;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class App {
    static final int MB = 1024 * 1024;
    byte[] b = new byte[4 * MB];

    public static void main(String[] args) {

        App app = new App();
        ReferenceQueue<App> referenceQueue = new ReferenceQueue<>();
        WeakReference<App> appSoftReference = new WeakReference<>(app, referenceQueue);
        app= null;
        Runtime.getRuntime().gc();
        System.out.println(referenceQueue.poll() == appSoftReference);
        byte[] c = new byte[4 * MB];

    }
}
