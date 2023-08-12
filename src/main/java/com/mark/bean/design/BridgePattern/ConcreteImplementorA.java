package com.mark.bean.design.BridgePattern;

public class ConcreteImplementorA implements  Implementor{ //具体实现
    @Override
    public void implementorImp() {
        System.out.println("使用小米手机打电话");
    }
}
