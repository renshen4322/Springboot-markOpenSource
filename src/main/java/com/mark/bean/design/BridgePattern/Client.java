package com.mark.bean.design.BridgePattern;

public class Client {
    public static void main(String[] args) {

        Implementor implementor1 = new ConcreteImplementorA();
        Implementor implementor2 = new ConcreteImplementorB();

        Abstraction abstraction = new RefinedAbstraction(implementor1);
        abstraction.operation();

        System.out.println("-=========================");
        Abstraction abstraction2 = new RefinedAbstraction2(implementor2);
        abstraction2.operation();


    }
}
