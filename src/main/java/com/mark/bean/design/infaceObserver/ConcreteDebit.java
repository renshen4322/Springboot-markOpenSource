package com.mark.bean.design.infaceObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:ConcreteDebit
 * Package:com.mark.springbootmarkopensource.bean.design.infaceObserver
 * Description:
 *
 * @Date:2021/4/3 0003 18:56
 * @Author: mark
 */
public class ConcreteDebit implements  Debit { //具体借贷方
    public String getName() {
        return name;
    }
    private String name;
    private List<Credit> allCredits = new ArrayList<Credit>(); //维护一个放贷方集合

    public ConcreteDebit(String name){
        this.name = name;
    }

    @Override
    public void borrow(Credit credit) { //借贷人向放贷人借钱
        allCredits.add(credit);  //添加放贷人到集合
    }

    @Override
    public void notifyCredits() {
        allCredits.forEach(credit -> credit.takeMoney(new ConcreteDebit(name)));
    }
}
