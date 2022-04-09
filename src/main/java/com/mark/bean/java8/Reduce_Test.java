///*
//package com.mark.springbootmarkopensource.bean.java8;
//
//
//import com.alibaba.fastjson.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Reduce_Test {
//    public static void main(String[] args) {
//
//        List<A> list = new ArrayList<A>();
//        list.add(new A("test",1, 2));
//        list.add(new A("test",100, 200));
//        list.add(new A("mark",50, 100));
//        list.add(new A("mark",30, 50));
//        A a = list.stream()
//                .reduce(
//                        (x , y) -> new A(x.getName(), (x.getPrincipal() + y.getPrincipal()), (x.getFee() + y.getFee()) ) )
//                .orElse( new A("",0, 0) );
//        System.out.println(a);
//        System.out.println("==================================================");
//        List<Foo> fooList = new ArrayList<>()
//                new Foo("A","san",1.0,2,30),
//                new Foo("A","nas",13.0,1,20),
//                new Foo("B","san",112.0,3,10),
//                new Foo("C","san",43.0,5,60),
//                new Foo("B","nas",77.0,7,23)
//        );
//        List<Bar> barList =new ArrayList<>();
//        fooList
//                .stream()
//                .collect(Collectors.groupingBy(Foo::getName,Collectors.toList()))
//                .forEach((name,fooListByName)->{
//                    Bar bar = new Bar();
//                    bar = fooListByName
//                            .stream()
//                            .reduce(bar,(u,t)->u.sum(t),(u,t)->u);
//                    //System.out.println(bar);
//                    barList.add(bar);
//                });
//
//        System.out.println(JSONObject.toJSON(barList));
//        System.out.println("=======================************************************");
//        System.out.println("系统一共有"+Runtime.getRuntime().availableProcessors()+"个cpu");
//      */
///*  JSONObject jsonObject = JSONObject.parseObject(null);
//
//        //第一种方式
//        String jsonString2 = JSONObject.toJSONString(jsonObject);
//
//        //第二种方式
//        String jsonString = jsonObject.toJSONString();
//        System.out.println(jsonString2);*//*
//
//    }
//}
//*/
