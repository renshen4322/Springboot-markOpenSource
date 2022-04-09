package com.mark.springbootmarkopensource.bean.design.observerMondel;

import java.util.List;

/**
 * ClassName:ConcreateObserver
 * Package:com.mark.springbootmarkopensource.bean.design.observerMondel
 * Description:
 *
 * @Date:2021/4/3 0003 18:00
 * @Author: mark
 */
public class ConcreateObserver extends Observer { //具体观察者
    private String name; // 观察者名称
    private String observerState; //观察者状态

    public ConcreateObserver(String name) { //构造方法
        this.name = name;
    }

    @Override
    public void update(Subject subject) {
        observerState = ((ConcreateSubject)subject).getSubjectState(); //体现与ConcreateSubject的关联
        System.out.println(name+"收到通知: "+observerState);
    }
}
