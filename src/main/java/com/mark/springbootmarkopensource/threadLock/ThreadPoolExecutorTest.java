package com.mark.springbootmarkopensource.threadLock;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        //FixedThreaPoolMethod();
        //singleTreadExecutorMethod();

        //CachedThreadPoolMethod();


        // scheduleAtFixedRateMethod();

        //scheduledTreadpoolScheduleMethod();


    }

    /**
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
     */
    private static void CachedThreadPoolMethod() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待2秒。
    private static void FixedThreaPoolMethod() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    //所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
    private static void singleTreadExecutorMethod() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    //表示延迟3秒执行。
    private static void scheduledTreadpoolScheduleMethod() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }


    //表示延迟1秒后 | 定期执行,每3秒执行一次。
    private static void scheduleAtFixedRateMethod() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

}
