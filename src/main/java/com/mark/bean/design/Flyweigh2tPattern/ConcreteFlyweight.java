package com.mark.bean.design.Flyweigh2tPattern;

public class ConcreteFlyweight implements FlyWeight{  //具体享元

    private String intrinsicState; //成员变量，表示内部状态

    public ConcreteFlyweight(String intrinsicState){
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println(extrinsicState+"正在"+intrinsicState+", 具体享元对象的hashcode为 "+this.hashCode());//内外部状态
    }
}
