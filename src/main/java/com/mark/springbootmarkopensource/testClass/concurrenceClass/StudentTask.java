package com.mark.springbootmarkopensource.testClass.concurrenceClass;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:StudentTask
 * Package:com.mark.springbootmarkopensource.bean.java8
 * Description:
 *
 * @Date:2019/4/9 0009 18:12
 * @Author: mark
 */
public class StudentTask implements Runnable {

    private Phaser phaser;

    public StudentTask(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"到达考试");
        phaser.arriveAndAwaitAdvance();


        System.out.println(Thread.currentThread().getName()+"做第1题时间..."+ doExercise1()+"分钟");

        System.out.println(Thread.currentThread().getName()+"做第1题完成...");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName()+"做第2题时间..."+doExercise2()+"分钟");

        System.out.println(Thread.currentThread().getName()+"做第2题完成...");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName()+"做第3题时间..."+doExercise3()+"分钟");

        System.out.println(Thread.currentThread().getName()+"做第3题完成...");
        phaser.arriveAndAwaitAdvance();
    }

    private Long doExercise1() {
        long duration = (long)(Math.random()*10+1);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  duration;
    }

    private Long doExercise2() {
        long duration = (long)(Math.random()*10+1);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  duration;
    }

    private Long doExercise3() {
        long duration = (long)(Math.random()*10+1);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  duration;
    }

}

/*
---------------------
        作者：山楂树男孩
        来源：CSDN
        原文：https://blog.csdn.net/u010739551/article/details/51083004
        版权声明：本文为博主原创文章，转载请附上博文链接！*/
