package com.mark.bean.design.Decorator2Parttern;

public class Milk extends Decorator{

    public Milk(Order order){
        super(order);
        setDes("牛奶");
        setPrice(2.0f);
    }
    @Override
    public float cost() { //重写抽象方法
        return super.getPrice()+super.getOrder().cost();
    }

}
