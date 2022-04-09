package com.mark.bean.java8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 1、V HashMap.computeIfAbsent(K , Function<K, V>) // 简化代码，如果指定的键尚未与值关联或与null关联，使用函数返回值替换。
 * 2、<R> Stream<R> map(Function<? super T, ? extends R> mapper); // 转换流
 */
public class FunctionTest {
    public static void main(String[] args) {
        applyTest();
        andThenTest();
        composeTest();
        test();
        comperThen();
    }

    /**
     * 1、apply 示例
     */
    private static void applyTest() {
        //示例1：定义一个funciton,实现将String转换为Integer
        Function<String, Integer> function = x -> Integer.parseInt(x);
        Integer a = function.apply("100");
        System.out.println(a.getClass());
        // 结果：class java.lang.Integer
    }

    /**
     * 2、andThen 示例
     */
    private static void andThenTest() {
        //示例2：使用andThen() 实现一个函数 y=10x + 10;
        //先执行 10 * x
        Function<Integer, Integer> function2 = x -> 10 * x;
        //通过andThen在执行 这里的x就等于上面的10 * x的值
        function2 = function2.andThen(x -> x + 10);
        System.out.println(function2.apply(2));
        //结果：30

    }

    /**
     * 3、compose 示例
     */
    private static void composeTest() {
        //示例3：使用compose() 实现一个函数 y=(10+x)2;
        Function<Integer, Integer> function3 = x -> x * 2;
        //先执行 x+10 在执行(x+10)*2顺序与上面相反
        function3 = function3.compose(x -> x + 10);
        System.out.println(function3.apply(3));
        //结果：26
    }

    /**
     * 4、综合示例
     */
    private static void test() {

//示例4：使用使用compose()、andThen()实现一个函数 y=(10+x)*2+10;
        //执行第二步
        Function<Integer, Integer> function4 = x -> x * 2;
        //执行第一步
        function4 = function4.compose(x -> x + 10);
        //执行第三步
        function4 = function4.andThen(x -> x + 10);
        System.out.println(function4.apply(3));
        //结果：36

    }

    public static void comperThen() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list;

// java8之前写法
        list = map.get("key");
        if (list == null) {
            list = new LinkedList<>();
            map.put("key", list);
        }
        list.add("11");

// 使用 computeIfAbsent 可以这样写 如果key返回部位空则返回该集合 ，为空则创建集合后返回
        list = map.computeIfAbsent("key", k -> new ArrayList<>());
        list.add("22");
        System.out.println("======================");
        list.stream().forEach(c->
                System.out.println(c)
                );
    }

    private static void mapTest() {
        List<Person> persionList2 = new ArrayList<Person>();
        persionList2.add(new Person(1, "张三", "男", 38));
        persionList2.add(new Person(2, "小小", "女", 2));
        persionList2.add(new Person(3, "李四", "男", 65));

        //1、只取出该集合中所有姓名组成一个新集合（将Person对象转为String对象）
        List<String> nameList2 = persionList2.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(nameList2.toString());

        List<Person> persionList = new ArrayList<Person>();
        persionList.add(new Person(1,"张三","男",38));
        persionList.add(new Person(2,"小小","女",2));
        persionList.add(new Person(3,"李四","男",65));
        persionList.add(new Person(4,"王五","女",20));
        persionList.add(new Person(5,"赵六","男",38));
        persionList.add(new Person(6,"大大","男",65));

        //1、只取出该集合中所有姓名组成一个新集合
        List<String> nameList=persionList.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(nameList.toString());

        //2、只取出该集合中所有id组成一个新集合
        List<Integer> idList=persionList.stream().mapToInt(Person::getId).boxed().collect(Collectors.toList());
        System.out.println(idList.toString());

        //3、list转map，key值为id，value为Person对象
        Map<Integer, Person> personmap = persionList.stream().collect(Collectors.toMap(Person::getId, person -> person));
        System.out.println(personmap.toString());

        //4、list转map，key值为id，value为name
        Map<Integer, String> namemap = persionList.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(namemap.toString());

        //5、进行map集合存放，key为age值 value为Person对象 它会把相同age的对象放到一个集合中
        Map<Integer, List<Person>> ageMap = persionList.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(ageMap.toString());

        //6、获取最小年龄
        Integer ageMin = persionList.stream().mapToInt(Person::getAge).min().getAsInt();
        System.out.println("最小年龄为: "+ageMin);

        //7、获取最大年龄
        Integer ageMax = persionList.stream().mapToInt(Person::getAge).max().getAsInt();
        System.out.println("最大年龄为: "+ageMax);

        //8、集合年龄属性求和
        Integer ageAmount = persionList.stream().mapToInt(Person::getAge).sum();
        System.out.println("年龄总和为: "+ageAmount);
    }


}
