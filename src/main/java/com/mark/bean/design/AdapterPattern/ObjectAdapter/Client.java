package com.mark.bean.design.AdapterPattern.ObjectAdapter;

import com.mark.bean.design.AdapterPattern.Adaptee;
import com.mark.bean.design.AdapterPattern.Target;

/**
 * 客户端
 */
public class Client {

    private static Target adapter;
    public static void main(String[] args) {
        adapter = new Adapter(new Adaptee());
        adapter.request();
    }
}
