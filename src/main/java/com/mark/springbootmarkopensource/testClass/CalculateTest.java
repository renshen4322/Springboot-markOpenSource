package com.mark.springbootmarkopensource.testClass;

/**
 * @Author: 胡东辉
 * @Description:
 * @Date: 2019/11/18 17:14
 * @Version: 1.0
 */
public class CalculateTest {
    public static void main(String[] args) {
       // getResult(11);
        //随机出一个数组中的数
        int [] arr = {7,2,3,4,9};
//产生0-(arr.length-1)的整数值,也是数组的索引
        int index=(int)(Math.random()*arr.length);
        int rand = arr[index];
        System.out.println("随机出的数组中的数："+rand);

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
}
