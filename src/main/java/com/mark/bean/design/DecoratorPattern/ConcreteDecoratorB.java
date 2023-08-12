package com.mark.bean.design.DecoratorPattern;

public class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(Component component){
        super(component);
    }
    @Override
    protected String operation() {
        return getComponent().operation()+",Java"; //累加
    }
}
