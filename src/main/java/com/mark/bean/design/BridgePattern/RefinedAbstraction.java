package com.mark.bean.design.BridgePattern;

public class RefinedAbstraction extends Abstraction{

    public  RefinedAbstraction(Implementor implementor){
        super(implementor);
    }

    @Override
    void operation() {
        System.out.println("使用平板手机");
        implementor.implementorImp();
    }
}
