package com.mark.testClass.concurrenceClass;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @Date:2022/8/5 11:57
 * @Author:
 */
public class SemaphoreCommodity {
    //商品池
    private Map<String, Semaphore> map=new ConcurrentHashMap<>();

    //初始化商品池
    public SemaphoreCommodity() {
        //手机10部
        map.put("phone",new Semaphore(10));
        //电脑4台
        map.put("computer",new Semaphore(4));
    }

    /**
     *
     * @param name 商品名称
     * @return 购买是否成功
     */
    public boolean getbuy(String name) throws Exception {

        Semaphore semaphore = map.get(name);
        while (true) {
            int availablePermit = semaphore.availablePermits();
            if (availablePermit==0) {
                //商品售空
                return  false;
            }
            boolean b = semaphore.tryAcquire(1, TimeUnit.SECONDS);
            if (b) {
                System.out.println("抢到商品了");
                ///处理逻辑
                return  true;
            }

        }

    }

    public static void main(String[] args) throws Exception {
        SemaphoreCommodity semaphoreCommodity=new SemaphoreCommodity();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    System.out.println(semaphoreCommodity.getbuy("computer"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }


}
