package com.mark.bean.design.infaceObserver;

/**
 * ClassName:ConcretCredit
 * Package:com.mark.springbootmarkopensource.bean.design.infaceObserver
 * Description:
 *
 * @Date:2021/4/3 0003 19:04
 * @Author: mark
 */
public class ConcretCredit implements Credit { //具体放贷方

    private String name; //放贷人姓名

    public ConcretCredit(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void takeMoney(Debit debit) {

        System.out.println(name+"收到通知："+((ConcreteDebit)debit).getName()+"连本带利息还我款");
    }
}
