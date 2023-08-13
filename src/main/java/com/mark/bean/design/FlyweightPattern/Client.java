package com.mark.bean.design.FlyweightPattern;

/**
 * 享元模式
 */
public class Client {
    public static void main(String[] args) {

        BikeFactory bikeFactory  = new BikeFactory();
        Bike bike1 = bikeFactory.getBike("mobike");  //摩拜单车 ，创建享元对象
        bike1.use(new User("张三")); //用户不共享
        Bike bike2 = bikeFactory.getBike("mobike");
        bike2.use(new User("李四")); //用户不共享
        System.out.println("已经使用2个对象的Hash码："+bike1.hashCode()+"----"+bike2.hashCode());

        System.out.println("享元池的享元对象数目："+bikeFactory.getBikeCount());
        System.out.println("===============================================");
        Bike bike3 = bikeFactory.getBike("hellobike"); //哈啰单车，创建新的享元对象
        bike3.use(new User("王五"));
        System.out.println("享元池的享元对象数目："+bikeFactory.getBikeCount());

    }
}
