package com.mark.springbootmarkopensource.testClass.concurrenceClass;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:ExchangerTest
 * Package:com.mark.springbootmarkopensource.testClass.concurrenceClass
 * Description:
 * Exchanger 可以用于遗传算法，遗传算法里需要选出两个人作为交配对象，这时会交换两人的数据，并使用交叉得出2个酱结果。
 * Exchanger 也可以用于校对工作，校对二次录入的灵气是否一致
 * @Date:2021/6/14 0014 17:02
 * @Author: mark
 */
public class ExchangerTest {
    private  static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService theadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        theadPool.execute(new Runnable() {
            @Override
            public void run() {
               try{
                   String A = "银行流水A"; //A录入银行流水数据
                   exgr.exchange(A);
               }catch (InterruptedException e){

               }

            }
        });

        theadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水A"; //B录入银行流水数据
                    String A = exgr.exchange(B);
                    System.out.println("A和B数据是否一致："+A.equals(B)+",A录入的是："+A+",B录入的是："+B);
                }catch (InterruptedException e){

                }
            }
        });
        theadPool.shutdown();

    }
}
