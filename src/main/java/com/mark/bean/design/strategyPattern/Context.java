package com.mark.bean.design.strategyPattern;

/**
 * ClassName:Context
 * Package:com.mark.springbootmarkopensource.bean.design.strategyPattern
 * Description:
 *
 * @Date:2021/4/4 0004 10:38
 * @Author: mark
 */
public class Context {  //定义上下文环境
    Strategy strategy;   //聚合Strategy对象

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {   //定义上下文接口的方法

        strategy.algorithmlnterface(); //调用策略算法接口
    }

}
