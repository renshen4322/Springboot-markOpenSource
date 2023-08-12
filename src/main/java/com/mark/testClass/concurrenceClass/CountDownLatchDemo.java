package com.mark.testClass.concurrenceClass;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * ClassName:CountDownLatchDemo
 * Package:com.mark.springbootmarkopensource.bean.java8
 * Description:
 *
 * @Date:2019/4/9 0009 16:08
 * @Author: mark CountDownLatchDemo
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int totalThread = 3;
        long start = System.currentTimeMillis();
        CountDownLatch countDown = new CountDownLatch(totalThread);
        for(int i = 0; i < totalThread; i++) {
            final String threadName = "Thread " + i;
            new Thread(() -> {
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "started"));
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                countDown.countDown();
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "ended"));
                //业务代码

            }).start();;
        }
        countDown.await();
        long stop = System.currentTimeMillis();
        System.out.println(String.format("Total time : %sms", (stop - start)));
    }
}
