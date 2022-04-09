package com.mark.springbootmarkopensource.bean.design.templatePattern;

/**
 * ClassName:ConcreteClass
 * Package:com.mark.springbootmarkopensource.bean.design.templatePattern
 * Description:
 *
 * @Date:2021/4/3 0003 22:44
 * @Author: mark
 */
public class ConcreteClass extends AbstractClass { //具体类1
    @Override
    protected void primitiveOperation1() {
        System.out.println("从中国银行取号");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("从中国银行交易");
    }

    @Override
    protected void primitiveOperation3() {
        System.out.println("给中国银行评价");
    }

    @Override
    public boolean isEvaluate(){
        return true;
    }

}
