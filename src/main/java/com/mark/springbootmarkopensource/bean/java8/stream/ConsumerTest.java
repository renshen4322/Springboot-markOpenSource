package com.mark.springbootmarkopensource.bean.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        //假设这里有个集合,集合里的对象有个status属性,现在我想对这个属性赋值一个固定值
        List<Person> personList = new ArrayList<>();
        //1、传统的通过for循环添加
        for (Person person : personList) {
            person.setStatus(1);
        }
        //2、通过forEach的Consumer添加
        personList.forEach(x -> x.setStatus(1));

        testConsumer();
        testAndThen();
    }

    /**
     * 一个简单的平方计算
     */
    public static void testConsumer() {
        //设置好Consumer实现方法
        Consumer<Integer> square = x -> System.out.println("平方计算 : " + x * x);
        //传入值
        square.accept(2);
    }
    /**
     * 定义3个Consumer并按顺序进行调用andThen方法
     */
    public static void testAndThen() {
        //当前值
        Consumer<Integer> consumer1 = x -> System.out.println("当前值 : " + x);
        //相加
        Consumer<Integer> consumer2 = x -> { System.out.println("相加 : " + (x + x)); };
        //相乘
        Consumer<Integer> consumer3 = x -> System.out.println("相乘 : " + x * x);
        //andThen拼接
        consumer1.andThen(consumer2).andThen(consumer3).accept(3);
    }
}
