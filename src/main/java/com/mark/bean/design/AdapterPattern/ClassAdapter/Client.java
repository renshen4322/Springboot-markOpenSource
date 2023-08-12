package com.mark.bean.design.AdapterPattern.ClassAdapter;

import com.mark.bean.design.AdapterPattern.Target;

/**
 * 测试类
 */
public class Client {

    private static Target adapter;  //client关联Target

    public static void main(String[] args) {
        adapter = new Adapter();
        adapter.request(); //调用接口方法
    }
}
