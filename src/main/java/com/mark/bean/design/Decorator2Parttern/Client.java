package com.mark.bean.design.Decorator2Parttern;

public class Client {
    public static void main(String[] args) {

        //step1
        Order order = new Coffee(); //初始订单，被装饰类
        System.out.println("描述："+order.getDes());
        System.out.println("费用："+order.cost()+"元");
        System.out.println("==================");

        //step2
        order = new Milk(order); //订单叠加，装饰类
        System.out.println("order加一份牛奶后的费用："+order.cost()+"元");
        System.out.println("描述："+order.getDes());
        System.out.println("====================");

        //step3
        order = new Chocolate(order); //订单叠加，装饰类
        System.out.println("order再加一份巧克力后的费用："+order.cost()+"元");
        System.out.println("描述："+order.getDes());
        System.out.println("====================");

        //step4
        order = new Chocolate(order); //订单叠加，装饰类
        System.out.println("order再加一份巧克力后的费用："+order.cost()+"元");
        System.out.println("描述："+order.getDes());
        System.out.println("====================");
    }
}
