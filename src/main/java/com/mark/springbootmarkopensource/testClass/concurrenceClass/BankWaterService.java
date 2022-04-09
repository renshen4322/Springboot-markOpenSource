package com.mark.springbootmarkopensource.testClass.concurrenceClass;

import java.util.Map;
import java.util.concurrent.*;

/**
 * ClassName:BankWaterService
 * Package:com.mark.springbootmarkopensource.testClass.concurrenceClass
 * Description:
 * CyclicBarrier可用于多线程计算数据，最后合并计算结果的场景
 * 如用一个Excel保存了用户所有银行流水，每个sheet保存一个账户近一年的每笔银行流水，
 * 现在需要统计用户的日均银行流水，先用多线程处理每个Sheet的流水，都执行完成之后，得到每个sheet的日均银行流水，
 * 最后再用barrierAction用这些线程的计算结果，计算出整个Excel的日均银行流水。
 *
 * @Date:2021/6/14 0014 15:56
 * @Author: mark
 */
public class BankWaterService implements Runnable{
    /**
     * 创建4个屏障，处理完之后执行当前类的run方法
     */
    private CyclicBarrier c = new CyclicBarrier(4,this);
    /**
     * 假设只有4个sheet，所以只启动4个线程。
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个sheet计算出的银行流水结果
     */
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<String,Integer>();

    private  void count(){
        for(int i=0; i<4; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //计算当前sheet的银流数据，计算代码省略
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    try{
                        //银流计算完成，插入一个屏障
                        c.await();
                    }
                    catch (InterruptedException | BrokenBarrierException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
         int result = 0;
         //汇总每个sheet计算出的结果
         for(Map.Entry<String,Integer> sheet:sheetBankWaterCount.entrySet()){
             result += sheet.getValue();
         }
         sheetBankWaterCount.put("result",result);
         System.out.println(result);
    }

    public static void main(String[] args){
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }

}
