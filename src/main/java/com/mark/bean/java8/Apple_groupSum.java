package com.mark.bean.java8;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @version: V1.0
 * @author: fendo
 * @className: Apple
 * @packageName: com.xxx.xxxx.xxxx.xxxx
 * @description: 苹果
 * @data: 2018-06-11 11:15
 **/
@Data
public class Apple_groupSum {

    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 总数
     */
    private Long count;

    /**
     * 总计
     */
    private BigDecimal total;

    /**
     * 类别
     */
    private String type;

    public Apple_groupSum() {

    }

    public Apple_groupSum(String id, String name, BigDecimal price, Long count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }



    public static void main(String[] args) {

        List<Apple_groupSum> appleList = new ArrayList<>();
        Apple_groupSum apple1 = new Apple_groupSum();
        apple1.setId("1");
        apple1.setName("fendo1");
        apple1.setCount((long) 10);
        apple1.setType("1");
        apple1.setPrice(new BigDecimal(20));
        appleList.add(apple1);

        Apple_groupSum apple2 = new Apple_groupSum();
        apple2.setId("2");
        apple2.setName("fendo2");
        apple2.setCount((long) 10);
        apple2.setType("1");
        apple2.setPrice(new BigDecimal(20));
        appleList.add(apple2);

        Apple_groupSum apple6 = new Apple_groupSum();
        apple6.setId("6");
        apple6.setName("fendo6");
        apple6.setCount((long) 30);
        apple6.setType("1");
        apple6.setPrice(new BigDecimal(20));
        appleList.add(apple6);

        Apple_groupSum apple3 = new Apple_groupSum();
        apple3.setId("3");
        apple3.setName("fendo3");
        apple3.setCount((long) 10);
        apple3.setType("2");
        apple3.setPrice(new BigDecimal(20));
        appleList.add(apple3);

        Apple_groupSum apple4 = new Apple_groupSum();
        apple4.setId("4");
        apple4.setName("fendo4");
        apple4.setCount((long) 10);
        apple4.setType("3");
        apple4.setPrice(new BigDecimal(20));
        appleList.add(apple4);

        Apple_groupSum apple5 = new Apple_groupSum();
        apple5.setId("5");
        apple5.setName("fendo5");
        apple5.setCount((long) 10);
        apple5.setType("4");
        apple5.setPrice(new BigDecimal(20));
        appleList.add(apple5);
        DoubleSummaryStatistics doubleTotal = new DoubleSummaryStatistics();
        appleList.stream().peek(c->{
            BigDecimal _total = c.getPrice().multiply(BigDecimal.valueOf(c.getCount()));
            c.setTotal(_total);
        }).collect(Collectors.toList());


        //分组
        Map<String,List<Apple_groupSum>> map = appleList.stream().collect(Collectors.groupingBy(Apple_groupSum::getType));
        for (Map.Entry<String, List<Apple_groupSum>> entry : map.entrySet()) {
            System.out.println("分组" + JSONObject.toJSON(entry));
        }
        DoubleSummaryStatistics doubleSummaryStatistics = appleList.stream().collect(Collectors.summarizingDouble(Apple_groupSum::getCount));
        System.out.println("列表和："+doubleSummaryStatistics.getSum());
        //分组求和
        Map<String, LongSummaryStatistics> collect = appleList.stream().collect(
                Collectors.groupingBy(Apple_groupSum::getType,
                        Collectors.summarizingLong(Apple_groupSum::getCount)));
        for (Map.Entry<String, LongSummaryStatistics> entry : collect.entrySet()) {
            LongSummaryStatistics longSummaryStatistics = entry.getValue();
            System.out.println("----------------key----------------" + entry.getKey());
            System.out.println("求和:" + longSummaryStatistics.getSum());
            System.out.println("求平均" + longSummaryStatistics.getAverage());
            System.out.println("求最大:" + longSummaryStatistics.getMax());
            System.out.println("求最小:" + longSummaryStatistics.getMin());
            System.out.println("求总数:" + longSummaryStatistics.getCount());
        }
        JSONObject jsonObject = new JSONObject();
        System.out.println();

    }


}

