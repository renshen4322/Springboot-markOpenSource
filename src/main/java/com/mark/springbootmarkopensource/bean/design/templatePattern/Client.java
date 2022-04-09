package com.mark.springbootmarkopensource.bean.design.templatePattern;

/**
 * ClassName:Client
 * Package:com.mark.springbootmarkopensource.bean.design.templatePattern
 * Description:
 *
 * @Date:2021/4/3 0003 22:49
 * @Author: mark 模板方法模式
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
        System.out.println("========================================");
        AbstractClass abstractClass2 = new ConcreteClass2();
        abstractClass2.templateMethod();
        System.out.println("================***************========================");
        Abstract1 abstract1 = new Concrete1();
        abstract1.test();
        abstract1.templateMethod();
    }
}
