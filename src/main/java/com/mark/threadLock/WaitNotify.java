package com.mark.threadLock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:WaitNotify
 * Package:com.mark.springbootmarkopensource.threadLock
 * Description:
 * WaitNotify使用实例
 * @Date:2021/5/30 0030 10:47
 * @Author: mark
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(),"WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(),"NotifyThread");
        notifyThread.start();
   }

    static  class  Wait implements Runnable{
        public void  run(){
            //加锁，拥有lock的Monitor
            synchronized (lock){
                //当条件不满足时，继续wait,同时释放了lock的锁
                while (flag){
                    try{
                        System.out.println(Thread.currentThread()+" flag is true.wait @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    }catch (InterruptedException e){
                    }
                }
                //条件满足时，完成工作
                System.out.println(Thread.currentThread()+" flag is false.running @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        }

    }

    static class Notify implements Runnable{
        public void run(){
            //加锁，拥有lock的Monitor
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock.notify @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock again.sleep @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
