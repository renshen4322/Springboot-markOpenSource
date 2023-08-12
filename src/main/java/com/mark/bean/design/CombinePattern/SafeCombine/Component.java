package com.mark.bean.design.CombinePattern.SafeCombine;

public abstract class Component {

    protected String name;
    public Component(String name){
        this.name = name;
    }
    protected abstract void operation();
}
