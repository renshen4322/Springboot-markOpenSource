package com.mark.bean.ComputeBeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 随机定位某一支配者
 */
public class TestGovernArray {
    public static void main(String[] args) {
        //test666();
        int[] ints = {9, 4, 9, 2, 1, 9, 9, 9};
        List<Integer> lt = new ArrayList<>();
        for (int i = 0; i <= ints.length - 1; i++) {
            lt.add(ints[i]);
        }
        System.out.println("=========================lt=======" + lt);
        int j = judge(ints);
        if (j == -1) {
            System.out.println("-1");
        } else {
            System.out.println("支配者是:" + ints[j]);
            int result = ints[j];
            List<Integer> list = new ArrayList<>();
            for (int m = 0; m < lt.size(); m++) {
                if (result == lt.get(m)) {
                    list.add(m);
                }
            }
            System.out.println("支配者在原数组中的下标：" );
            System.out.println(list);
            Object[] objs = list.toArray();
            ////产生0-(arr.length-1)的整数值,也是数组的索引
            int index = (int) (Math.random() * objs.length);
            int rand = (int) objs[index];
            System.out.println("随机返回支配者在原数组中的下标：" + rand);

        }

    }


    public static int judge(int[] ints) {
        Arrays.sort(ints);
        int counter = 1;
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] == ints[i + 1]) {
                counter++;
                if (((double) counter) / ints.length > 0.5) {
                    System.out.println("counter: " + counter);
                    return i;
                }
            } else {
                counter = 1;
            }
        }
        return -1;
    }

}
