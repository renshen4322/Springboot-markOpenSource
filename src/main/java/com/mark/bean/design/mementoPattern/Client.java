package com.mark.bean.design.mementoPattern;

/**
 * ClassName:Client
 * Package:com.mark.springbootmarkopensource.bean.design.mementoPattern
 * Description:
 *
 * @Date:2021/4/3 0003 21:56
 * @Author: mark 备忘录模式
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("状态#1 攻击力 100");
        caretaker.setMemento(originator.createMemento());
        originator.setMemento(caretaker.getMemento());
        System.out.println("当前状态："+originator.getState());
        originator.setState("状态#2 攻击力 100");
        caretaker.setMemento(originator.createMemento());
        originator.setMemento(caretaker.getMemento());
        System.out.println("当前状态："+originator.getState());
        originator.setState("状态#3 攻击力 100");
        caretaker.setMemento(originator.createMemento());
        originator.setMemento(caretaker.getMemento());
        System.out.println("当前状态："+originator.getState());
        //撤消只能undo到上一个状态
        System.out.println("====撤消（Undo）到上一个状态====");
        originator.setMemento(caretaker.getMemento());
        System.out.println("当前状态："+originator.getState());
    }
}
