package com.mark.springbootmarkopensource.bean.ComputeBeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestArray {

    public static void main(String[] args) {
        //getResult(10);



        extracted();
    }

    /**
     *  1，找出一个数组中字符出现的次数，map输出
     */
    private static void extracted() {
        String[] arr = new String[]{"aaa", "bbb", "ccc", "ddd", "ddd", "aaa"};
        Map<String, Integer> map = new ConcurrentHashMap<>();
        for (String str : arr) {
            Integer num = map.get(str);
            map.put(str, num == null ? 1 : num + 1);
        }
        for (String mp:map.keySet()) {
            System.out.println("key " + mp + " 出现次数 : " + map.get(mp));
        }
    }

    /**
     * 数组中二二组合 为一个指定的数
     * @param result
     */
    public static void getResult(int result) {
        int[] arr = new int[]{0, 2, 3, 1, 4, 10, 23, 7, 8, 9, 6, 3};
        for (int i = 0; i < arr.length; i++) {
            int startItem = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (i == j)
                    continue;
                int endItem = arr[j];
                if ((startItem + endItem) == result)
                    System.out.println(startItem + "+" + endItem + "=" + result);

            }

        }
    }
    //给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
    // 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
    // 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
    // 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
    // {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
    // {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> ans =new ArrayList<>();
        if (num.length == 0 || size == 0 || size > num.length){
            return ans;
        }
//        int index = 0;
        int Max = Integer.MIN_VALUE;
        int pos = -1;
        for (int i = 0; i < size ; i++){
            if (num[i] > Max){
                Max = num[i];
                pos = i;
            }
        }
        ans.add(Max);
        for (int i = size;i<= num.length - 1; i++){//i-->窗口的右区间
            if (i - size + 1 <= pos ){
                if (num[i] >Max){
                    Max = num[i];
                    pos = i;
                }
            }else {
                Max = Integer.MIN_VALUE;
                for (int j = i - size + 1; j <=i;j++){
                    if (num[j] > Max){
                        Max = num[j];
                        pos = j;
                    }
                }
            }
            ans.add(Max);
        }
        return ans;
    }
}


