package com.mark.testClass.concurrenceClass;



import java.util.concurrent.Semaphore;

/**
 * ClassName:SemaphoreTest
 * Package:com.mark.springbootmarkopensource.bean.java8
 * Description:
 *
 * @Date:2019/4/9 0009 23:39
 * @Author: mark
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=1;i<=N;i++) {
            new Worker(i, semaphore).start();
        }
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(1000);
                semaphore.release();
                System.out.println("工人"+this.num+"释放出机器");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //https://www.cnblogs.com/xing901022/p/8696550.html
}
