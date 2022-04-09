package com.mark.bean.design.observerMondel;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Subject
 * Package:com.mark.springbootmarkopensource.bean.designmondel.observerMondel
 * Description:
 *
 * @Date:2021/4/3 0003 17:38
 * @Author: mark 观察者模式
 */
abstract class Subject { //目标
    //维系若干观察者，体现Subject 对Observer 的关联
    private List<Observer> observers = new ArrayList<>();


    public List<Observer> getObservers() {
        return observers;
    }

    public void notifyToAll() {
        for (Observer observer:observers) {
           observer.update(this);
        }

    }
    public abstract void attach(Observer observer); //附加观察者
    public abstract void detach(Observer observer); //移除观察者

}
