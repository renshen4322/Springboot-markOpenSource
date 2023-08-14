package com.mark.bean.design.Flyweigh2tPattern;

/**
 * 享元模式
 */
public class Client {

    public static void main(String[] args) {
        //下棋各类为内部状态，下栱者为外部状态
        //Client 关联FlyweightFactory
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        //client 关联ConcreteFlyweight 创建可共享的具体享元对象
        ConcreteFlyweight flyweight = (ConcreteFlyweight) flyweightFactory.getFlyweight("下围棋");
        flyweight.operation("张三"); //传入外部状态
        flyweight.operation("李四");

        System.out.println("============================================================");
        flyweight = (ConcreteFlyweight) flyweightFactory.getFlyweight("下象棋");
        flyweight.operation("张三"); //传入外部状态
        flyweight.operation("李四");

        //Client 关联UnSharedConcreteFlyweight; 创建非共享具体享元对象
        System.out.println("=============================================================");
        UnSharedConcreteFlyweight flyweight2= (UnSharedConcreteFlyweight) flyweightFactory.getFlyweight("UnShared");//创建享元工厂类
        flyweight2.operation("王五");
        flyweight2.operation("赵六");





    }
}
