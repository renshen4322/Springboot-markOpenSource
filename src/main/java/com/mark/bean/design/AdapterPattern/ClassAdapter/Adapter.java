package com.mark.bean.design.AdapterPattern.ClassAdapter;

import com.mark.bean.design.AdapterPattern.Adaptee;
import com.mark.bean.design.AdapterPattern.Target;

/**
 * 适配器（类继承+实现标准接口）
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        //调用基类方法
        super.specificRequest();
    }
}
