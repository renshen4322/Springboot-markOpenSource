package com.mark.springbootmarkopensource.threadLock;

public class TestThread1 {
    public static void main(String[] args) {
        Object lock = new Object();
        MyThread1 t1 = new MyThread1(lock);
        t1.start();
        try {
            Thread.sleep(2000);
            MyThread2 t2 = new MyThread2(lock);
            t2.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
