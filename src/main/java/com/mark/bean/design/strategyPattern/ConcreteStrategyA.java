package com.mark.bean.design.strategyPattern;

/**
 * ClassName:ConcreteStrategyA
 * Package:com.mark.springbootmarkopensource.bean.design.strategyPattern
 * Description:
 *
 * @Date:2021/4/4 0004 10:46
 * @Author: mark
 */
public class ConcreteStrategyA implements  Strategy { //具体策略类A
    @Override
    public void algorithmlnterface() {
        System.out.println("Speak English");
    }
}
