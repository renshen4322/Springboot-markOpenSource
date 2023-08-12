package com.mark.bean.design.DecoratorPattern;



public class ConcreteDecoratorA extends Decorator{

    public ConcreteDecoratorA(Component component){
        super(component);
    }
    @Override
    protected String operation() {
        return getComponent().operation()+",C++"; //累加
    }
}
