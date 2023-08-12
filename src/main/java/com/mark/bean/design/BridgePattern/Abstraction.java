package com.mark.bean.design.BridgePattern;

public abstract class Abstraction {  //抽象类 手机
    protected Implementor implementor; //聚合品牌接口

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    abstract void operation(); //抽象方法
}
