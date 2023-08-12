package com.mark.bean.design.DecoratorPattern;

public abstract class Decorator extends Component{ //抽象装饰类(核心类)

    private Component component; //维护一个抽象构件（父类对象）
    public Decorator(Component component){
        this.component = component;
    }

    public Component getComponent(){
        return component;
    }


}
