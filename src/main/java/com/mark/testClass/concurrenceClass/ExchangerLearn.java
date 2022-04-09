package com.mark.testClass.concurrenceClass;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:ExchangerLearn
 * Package:com.mark.springbootmarkopensource.bean.java8
 * Description:
 *
 * @Date:2019/4/9 0009 14:12
 * @Author: mark
 */
public class ExchangerLearn {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Exchanger<String> exchanger = new Exchanger<String>();
        service.execute(new Runnable(){
            public void run() {
                try {
                    String data1 = "data1";
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "正在把数据" + data1 +"换出去");
                    Thread.sleep((long)(Math.random()*1000));
                    String data2 = (String)exchanger.exchange(data1);
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "换回的数据为" + data2);
                }catch(Exception e){
                }
            }
        });
        service.execute(new Runnable(){
            public void run() {
                try {
                    String data1 = "data2";
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "正在把数据" + data1 +"换出去");
                    Thread.sleep((long)(Math.random()*1000));
                    String data2 = (String)exchanger.exchange(data1);
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "换回的数据为" + data2);
                }catch(Exception e){
                }
            }
        });
    }
/*
---------------------
    作者：:：：::
    来源：CSDN
    原文：https://blog.csdn.net/weixin_40577289/article/details/88550300
    版权声明：本文为博主原创文章，转载请附上博文链接！
*/
}
