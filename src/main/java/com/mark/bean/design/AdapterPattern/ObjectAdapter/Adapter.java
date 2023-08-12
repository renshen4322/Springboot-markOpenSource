package com.mark.bean.design.AdapterPattern.ObjectAdapter;

import com.mark.bean.design.AdapterPattern.Adaptee;
import com.mark.bean.design.AdapterPattern.Target;

/**
 * 适配器
 */
public class Adapter implements Target {

    private Adaptee adaptee;  //聚合Adaptee

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
