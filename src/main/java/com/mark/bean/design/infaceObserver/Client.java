package com.mark.bean.design.infaceObserver;

/**
 * ClassName:Client
 * Package:com.mark.springbootmarkopensource.bean.design.infaceObserver
 * Description:
 *
 * @Date:2021/4/3 0003 19:11
 * @Author: mark  接口方式实现观察者模式
 */
public class Client {
    public static void main(String[] args) {
        ConcreteDebit zhangsan = new ConcreteDebit("张三"); //创建一个具体借贷人
        zhangsan.borrow(new ConcretCredit("李四"));
        zhangsan.borrow(new ConcretCredit("王五"));
        zhangsan.borrow(new ConcretCredit("赵六"));
        zhangsan.notifyCredits();
    }
}
