package com.mark.bean.design.Decorator3Pattern;

/**
 * 具体构件，被装饰类
 */
public class IceCream extends DQ{
    @Override
    protected void operation() {
        System.out.print("DQ牌冰淇淋 ");
    }
}
