package com.mark.bean.design.Decorator3Pattern;

public class ChocolateChip extends Decorator{

    @Override
    public void operation(){
        super.operation();
        System.out.print(" ,添加了巧克力"); //装饰
    }
}
