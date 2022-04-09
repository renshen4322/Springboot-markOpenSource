package com.mark.springbootmarkopensource.bean.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ParallelStreamTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("运行结果：");
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //for
        Long forBegin = System.currentTimeMillis();
        for(Integer number : numberList){
            //System.out.println(String.format("For The Current Thread's ID is %d and output number %d ",Thread.currentThread().getId(),number));
            Thread.sleep(1000);
        }
        System.out.println(String.format("For execute time cost %d ms",System.currentTimeMillis()-forBegin));
        System.out.println("\r");
        // stream method
        Long streamBegin = System.currentTimeMillis();
        numberList.stream().forEach(number -> {
            //System.out.println(String.format("Stream The Current Thread's ID is %d and output number %d ",Thread.currentThread().getId(),number));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(String.format("Stream execute time cost %d ms",System.currentTimeMillis()-streamBegin));
        System.out.println("\r");
        // parallelStream method
        Long parallelStreamBegin = System.currentTimeMillis();
        numberList.parallelStream().forEach(number -> {
            //System.out.println(String.format("ParallelStream The Current Thread's ID is %d and output number %d ",Thread.currentThread().getId(),number));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(String.format("ParallelStream execute time cost %d ms",System.currentTimeMillis()-parallelStreamBegin));
        System.out.println("\r");
        // parallelStream method
        Long parallelStreamForEachOrderBegin = System.currentTimeMillis();
        numberList.parallelStream().forEachOrdered(number -> {
            //System.out.println(String.format("ParallelStream forEachOrdered The Current Thread's ID is %d and output number %d ",Thread.currentThread().getId(),number));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(String.format("ParallelStream forEachOrdered execute time cost %d ms",System.currentTimeMillis()-parallelStreamForEachOrderBegin));
        System.out.println("\r");
    }
}
