package com.mark.bean.design.DecoratorPattern;

/**
 * 装饰者模式
 */
public class Client {

    public static void main(String[] args) {

        Component concreteComponent = new ConcreteComponent(); //被装饰对象无参
        System.out.println("大一："+concreteComponent.operation());
        System.out.println("===================================");

        Decorator concreteDecoratorA = new ConcreteDecoratorA(concreteComponent); //装饰
        System.out.println("大二："+concreteDecoratorA.operation());
        System.out.println("===================================");

        Decorator concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA); //再装饰
        System.out.println("大三："+concreteDecoratorB.operation());
        System.out.println("===================================");
    }
}
