package com.mark.threadLock;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class test00 {
    public static void main(String[] args) {
        String fl = null;
        String isFimaily = "1" == fl ? "Y" : "N";
        System.out.println(isFimaily);
        System.out.println("=====================================");
        Date dt = new Date();
        System.out.println(dt.getTime());
        System.out.println("==========================");

        System.out.println("人生如梦，岁月如歌");
        Object testObject = new ArrayList();
        displayObjectClass(testObject);
    }


    public static void displayObjectClass(Object o) {
        if (o instanceof Vector) {
            System.out.println("对象是 java.util.Vector 类的实例");
        } else if (o instanceof ArrayList) {
            System.out.println("对象是 java.util.ArrayList 类的实例");
        } else {
            System.out.println("对象是 " + o.getClass() + " 类的实例");
        }
    }
}
