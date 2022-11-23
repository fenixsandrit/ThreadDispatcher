package com.company.Test;

public class ThreadF implements Runnable{
    @Override
    public void run() {

        MainTest.common.incrementAndGet();
    }
}
