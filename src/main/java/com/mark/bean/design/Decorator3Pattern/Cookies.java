package com.mark.bean.design.Decorator3Pattern;

public class Cookies extends Decorator { //具体装饰类
    @Override
    public void operation() {
        super.operation();
        System.out.print(" ,添加了饼干"); //装饰
    }
}
