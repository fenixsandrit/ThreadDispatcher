package com.company.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class MainTest {
    public static AtomicInteger common = new AtomicInteger(0);

    public static void main(String[] args) {
        new Thread(new ThreadF()).start();
        new Thread(new ThreadF()).start();
        new Thread(new ThreadF()).start();
        new Thread(new ThreadF()).start();
        new Thread(new ThreadF()).start();
        new Thread(new ThreadF()).start();
        new Thread(new ThreadF()).start();
        new Thread(new ThreadF()).start();
        new Thread(new ThreadF()).start();
        new Thread(new ThreadF()).start();

        synchronized (common) {
            System.out.println(common);
        }
    }
}
