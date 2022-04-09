package com.mark.springbootmarkopensource.bean.design.mementoPattern;

/**
 * ClassName:Caretaker
 * Package:com.mark.springbootmarkopensource.bean.design.mementoPattern
 * Description:
 *
 * @Date:2021/4/3 0003 21:54
 * @Author: mark
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }
    public void setMemento(Memento memento){//setter
        this.memento = memento;
    }

}
