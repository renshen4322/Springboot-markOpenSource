package com.mark.springbootmarkopensource.bean.java8;

/**
 * ClassName:TestSort
 * Package:com.mark.springbootmarkopensource.bean.java8
 * Description:
 *
 * @Date:2019/3/20 0020 17:52
 * @Author: mark
 */
public class TestSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 109, 22, 5, 106, 12, 65, 7};
        int temp = 0;
        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = 0; j < arr.length - i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
     /*   for (int c = arr.length - 1; c >=0 ; c--) {
            System.out.println(arr[c]);
        }*/
    }
}
