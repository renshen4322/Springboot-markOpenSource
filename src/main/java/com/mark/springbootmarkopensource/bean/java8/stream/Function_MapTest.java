package com.mark.springbootmarkopensource.bean.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Function_MapTest {
    public static void main(String[] args) {
        List<Person> persionList = new ArrayList<Person>();
        persionList.add(new Person(1,"张三","男",38));
        persionList.add(new Person(2,"小小","女",2));
        persionList.add(new Person(3,"李四","男",65));
        persionList.add(new Person(4,"王五","女",20));
        persionList.add(new Person(5,"赵六","男",38));
        persionList.add(new Person(6,"大大","男",65));

        //1、只取出该集合中所有姓名组成一个新集合
        System.out.println("1、只取出该集合中所有姓名组成一个新集合");
        List<String> nameList=persionList.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(nameList.toString());

        //2、只取出该集合中所有id组成一个新集合
        System.out.println("2、只取出该集合中所有id组成一个新集合");
        List<Integer> idList=persionList.stream().mapToInt(Person::getId).boxed().collect(Collectors.toList());
        System.out.println(idList.toString());

        //3、list转map，key值为id，value为Person对象
        System.out.println("3、list转map，key值为id，value为Person对象");
        Map<Integer, Person> personmap = persionList.stream().collect(Collectors.toMap(Person::getId, person -> person));
        System.out.println(personmap.toString());

        //4、list转map，key值为id，value为name
        System.out.println("4、list转map，key值为id，value为name");
        Map<Integer, String> namemap = persionList.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(namemap.toString());

        //5、进行map集合存放，key为age值 value为Person对象 它会把相同age的对象放到一个集合中
        System.out.println("5、进行map集合存放，key为age值 value为Person对象 它会把相同age的对象放到一个集合中");
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
