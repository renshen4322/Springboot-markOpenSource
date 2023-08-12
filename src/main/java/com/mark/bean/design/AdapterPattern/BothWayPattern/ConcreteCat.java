package com.mark.bean.design.AdapterPattern.BothWayPattern;

public class ConcreteCat implements Cat{
    @Override
    public void catchMouse() {
        System.out.println("抓老鼠……");
    }
}
