package com.mark.bean.design.DecoratorPattern;

public class ConcreteComponent extends Component{ //具体构件 （被装饰类）
    @Override
    protected String operation() {
        return "我学习过的编程语言有：C语言";
    }
}
