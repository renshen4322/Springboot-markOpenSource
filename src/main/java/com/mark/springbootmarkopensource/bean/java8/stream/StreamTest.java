package com.mark.springbootmarkopensource.bean.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName:StreamTest
 * Package:com.mark.springbootmarkopensource.bean.java8.stream
 * Description:
 *
 * @Date:2021/6/19 0019 5:51
 * @Author: mark
 */
public class StreamTest {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());


        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);


        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数 map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        squaresList.forEach(c->System.out.println(c));


        List<String> string2s = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
// 获取空字符串的数量,filter筛选
        long count = string2s.stream().filter(string -> string.isEmpty()).count();
        System.out.println("获取空字符串的数量:"+count);


        List<String> string3s = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
// 获取空字符串的数量
        long count2 = string3s.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count2);
        //Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
        List<String> filtered2 = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered2);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);



        List<Integer> numbers2 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers2.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

        StreamTest java8Tester = new StreamTest();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        //System.out.println(java8Tester.sum(a,b));
    }
    public static Integer sum(Optional<Integer> a, Optional<Integer> b){
        // Optional.isPresent - 判断值是否存在
        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());
        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 =  b.orElse(new Integer(0));//b.get();
        return value1 + value2;
    }
}
