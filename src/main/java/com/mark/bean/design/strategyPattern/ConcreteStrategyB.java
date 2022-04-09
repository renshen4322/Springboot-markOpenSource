package com.mark.bean.design.strategyPattern;

/**
 * ClassName:ConcreteStrategyB
 * Package:com.mark.springbootmarkopensource.bean.design.strategyPattern
 * Description:
 *
 * @Date:2021/4/4 0004 10:49
 * @Author: mark
 */
public class ConcreteStrategyB implements  Strategy {
    @Override
    public void algorithmlnterface() {
        System.out.println("Speak Chinese");
    }
}
