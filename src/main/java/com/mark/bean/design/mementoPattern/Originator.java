package com.mark.bean.design.mementoPattern;

/**
 * ClassName:Originator
 * Package:com.mark.springbootmarkopensource.bean.design.mementoPattern
 * Description:
 *
 * @Date:2021/4/3 0003 21:45
 * @Author: mark
 */
public class Originator {  //原发器  //用于创建和恢复备忘录

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento memento){
        state = memento.getState();
    }

}
