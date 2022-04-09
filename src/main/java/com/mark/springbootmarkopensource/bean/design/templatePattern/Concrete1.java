package com.mark.springbootmarkopensource.bean.design.templatePattern;

/**
 * ClassName:Concrete1
 * Package:com.mark.springbootmarkopensource.bean.design.templatePattern
 * Description:
 *
 * @Date:2021/4/3 0003 23:12
 * @Author: mark
 */
public class Concrete1 implements Abstract1 {
    @Override
    public void primitiveOperation1() {
        System.out.println("从招商银行取号");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("从招商银行交易");
    }

    @Override
    public void primitiveOperation3() {
        System.out.println("给招商银行评价");
    }

    @Override
    public boolean isEvaluate() {
        return true;
    }


}
