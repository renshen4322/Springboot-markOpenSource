package com.mark.springbootmarkopensource.bean.design.templatePattern;

/**
 * ClassName:ConcreteClass2
 * Package:com.mark.springbootmarkopensource.bean.design.templatePattern
 * Description:
 *
 * @Date:2021/4/3 0003 22:46
 * @Author: mark
 */
public class ConcreteClass2 extends AbstractClass {//具体类2，供扩展用
    @Override
    protected void primitiveOperation1() {
        System.out.println("从建设银行取号");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("从建设银行交易");
    }

    @Override
    protected void primitiveOperation3() {
        System.out.println("从建设银行评价");
    }

    @Override
    public boolean isEvaluate() {
        return false;
    }
}
