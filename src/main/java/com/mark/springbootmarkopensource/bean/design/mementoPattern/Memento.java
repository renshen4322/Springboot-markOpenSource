package com.mark.springbootmarkopensource.bean.design.mementoPattern;

/**
 * ClassName:Memento
 * Package:com.mark.springbootmarkopensource.bean.design.mementoPattern
 * Description:
 *
 * @Date:2021/4/3 0003 21:47
 * @Author: mark
 */
public class Memento { //备忘录，相当于一个实体类
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private  String state;

    public Memento(String state) {  //构造方法
        this.state = state;
    }


}
