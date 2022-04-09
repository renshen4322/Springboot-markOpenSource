package com.mark.bean.design.strategyPattern;

/**
 * ClassName:Client
 * Package:com.mark.springbootmarkopensource.bean.design.strategyPattern
 * Description:
 *
 * @Date:2021/4/4 0004 10:50
 * @Author: mark 策略模式
 */
public class Client {
    public static void main(String[] args) {
        Strategy strategyA = new ConcreteStrategyA();
        Context context = new Context();
        context.setStrategy(strategyA);
        context.contextInterface();
    }
}
