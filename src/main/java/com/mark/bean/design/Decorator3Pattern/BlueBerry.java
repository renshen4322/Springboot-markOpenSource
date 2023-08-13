package com.mark.bean.design.Decorator3Pattern;

public class BlueBerry extends Decorator{

    @Override
    public void operation(){
        super.operation();
        System.out.print(" ,添加了蓝莓"); //装饰
    }
}
