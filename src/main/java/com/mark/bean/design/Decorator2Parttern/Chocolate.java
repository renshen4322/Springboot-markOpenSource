package com.mark.bean.design.Decorator2Parttern;

/**
 * 具体装饰类
 */
public class Chocolate extends Decorator{

    public Chocolate(Order order){
        super(order);
        setDes("巧克力");
        setPrice(3.0f);
    }
    @Override
    public float cost() { //重写抽象方法
        return super.getPrice()+super.getOrder().cost();
    }
}
