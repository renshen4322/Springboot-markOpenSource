package com.mark.bean.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentMain {
    public static void main(String[] args) {

        Student s1 = new Student(1L, "肖战", 18, "湖南");
        Student s2 = new Student(2L, "王一博", 25, "湖北");
        Student s3 = new Student(3L, "杨紫", 22, "北京");
        Student s4 = new Student(4L, "李现", 37, "浙江");
        Student s5 = new Student(1L, "肖战", 18, "湖南");
        Student s6 = new Student(4L, "李现", 37, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
     /*   List<Student> streamStudents = testFilter(students);
        streamStudents.forEach(System.out::println);*/

        //testMap(students);
        System.out.println("*********************************************");
        //testDistinct1();
        System.out.println("**********************==student去重=====*****************");
        // students.stream().distinct().forEach(System.out::println);
        System.out.println("============studentr年龄降序=================");
        //testSort1();
        students.stream().distinct()
                .sorted((stu1, stu2) -> Long.compare(stu2.getId(), stu1.getId()))
                //.sorted((stu1,stu2) -> Integer.compare(stu2.getAge(),stu1.getAge()))
                .forEach(System.out::println);
        System.out.println("***************集合limit，返回前几个元素*************||");
        testLimit();
        System.out.println("************集合skip，删除前n个元素***************");
        testSkip();
        System.out.println("-----+++++++++聚合+++++++++++++++");
        testReduce();
        Student minS = students.stream().distinct().min((stu1,stu2) ->Integer.compare(stu1.getAge(),stu2.getAge())).get();
        System.out.println("年龄最小的学生："+minS.toString());
        System.out.println("-----+++++++++匹配+++++++++++++++");
        Boolean anyMatch = students.stream().anyMatch(s ->"湖北".equals(s.getAddress()));
        if (anyMatch) {
            System.out.println("有湖北人");
        }
        Boolean allMatch = students.stream().allMatch(s -> s.getAge()>=15);
        if (allMatch) {
            System.out.println("所有学生都满15周岁");
        }
        Boolean noneMatch = students.stream().noneMatch(s -> "杨洋".equals(s.getName()));
        if (noneMatch) {
            System.out.println("没有叫杨洋的同学");
        }

   /*     anyMatch：Stream 中任意一个元素符合传入的 predicate，返回 true

        allMatch：Stream 中全部元素符合传入的 predicate，返回 true

        noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true*/


    }

    /**
     * 集合的筛选
     *
     * @param students
     * @return
     */
    private static List<Student> testFilter(List<Student> students) {
        //筛选年龄大于15岁的学生
        return students.stream().filter(s -> s.getAge()>15).collect(Collectors.toList());
        //筛选住在浙江省的学生
        //return students.stream().filter(s -> "浙江".equals(s.getAddress())).collect(Collectors.toList());
    }


    /**
     * 集合转换
     *
     * @param students
     * @return
     */
    private static void testMap(List<Student> students) {
        //在地址前面加上部分信息，只获取地址输出
        List<String> addresses = students.stream().map(s -> s.getName() + "_住址:" + s.getAddress()).collect(Collectors.toList());
        addresses.forEach(a -> System.out.println(a));
    }

    /**
     * 集合去重（基本类型）
     */
    private static void testDistinct1() {
        //简单字符串的去重
        List<String> list = Arrays.asList("111", "222", "333", "111", "222");
        list.stream().distinct().forEach(System.out::println);
    }

    /* 集合排序（默认升序排序）只对数字有效
     */
    private static void testSort1() {
        List<Integer> list = Arrays.asList(333, 888, 111, 5665, 213, 23, 98, 7);
        list.stream().sorted().forEach(System.out::println);
    }

    /**
     * 集合limit，返回前几个元素
     */
    private static void testLimit() {
        List<String> list = Arrays.asList("333", "222", "111", "888", "6665");
        list.stream().limit(3).forEach(System.out::println);
    }

    /**
     * 集合skip，删除前n个元素
     */
    private static void testSkip() {
        List<String> list = Arrays.asList("333","222","111","888", "6665");
        list.stream().skip(2).forEach(System.out::println);
    }
    /**
     * 集合reduce,将集合中每个元素聚合成一条数据
     */
    private static void testReduce() {
        List<String> list = Arrays.asList("欢","迎","你");
        String appendStr = list.stream().reduce("北京",(a,b) -> a+b);
        System.out.println(appendStr);
    }

}
