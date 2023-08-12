package com.mark.bean.design.BridgePattern;

public class RefinedAbstraction2 extends Abstraction{


    public  RefinedAbstraction2(Implementor implementor){
        super(implementor);
    }

    @Override
    void operation() {
        System.out.println("使用折叠手机");
        implementor.implementorImp();
    }
}
