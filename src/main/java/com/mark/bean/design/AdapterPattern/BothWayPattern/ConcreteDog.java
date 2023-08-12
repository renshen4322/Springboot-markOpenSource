package com.mark.bean.design.AdapterPattern.BothWayPattern;

public class ConcreteDog implements Dog{
    @Override
    public void gnawBone() {
        System.out.println("啃骨头……");
    }
}
