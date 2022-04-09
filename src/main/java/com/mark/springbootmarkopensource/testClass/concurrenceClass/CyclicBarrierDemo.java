package com.mark.springbootmarkopensource.testClass.concurrenceClass;

import java.util.Date;
import java.util.concurrent.CyclicBarrier;

/**
 * ClassName:CyclicBarrierDemo
 * Package:com.mark.springbootmarkopensource.bean.java8
 * Description:
 *
 * @Date:2019/4/9 0009 16:50
 * @Author: mark
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int totalThread = 5;
        CyclicBarrier barrier = new CyclicBarrier(totalThread);

        for(int i = 0; i < totalThread; i++) {
            String threadName = "Thread " + i;
            new Thread(() -> {
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, " is waiting"));
                try {
                    barrier.await();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "ended"));
            }).start();
        }
    }
}
