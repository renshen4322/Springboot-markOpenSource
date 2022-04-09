package com.mark.bean.java8;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName:TestMapInfo
 * Package:com.mark.springbootmarkopensource.bean.java8
 * Description:
 *
 * @Date:2019/3/26 0026 17:09
 * @Author: mark
 */
public class TestMapInfo {
    /**
     * 算法题集锦
     *
     * @param args
     */
    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        //method_01();
        //method_02();

        //数组叠加
        /*long startTime2 = System.currentTimeMillis();
        System.out.println("数组叠加实现：" + fun2(50));
        long endTime2 = System.currentTimeMillis();
        System.out.println("数组叠加实现-程序运行时间：" + (endTime2 - startTime2) + "ms");*/


        //递归方法非常慢
      /*  long startTime1 = System.currentTimeMillis();
        System.out.println("递归方法解决：" + fun(50));
        long endTime1 = System.currentTimeMillis();
        System.out.println("递归方法解决-程序运行时间：" + (endTime1 - startTime1) + "ms");*/

        //houziMeet();


        int result = calculate(100);
        System.out.println("1+2+3+...+100=" + result);
        //camlBall8();
       /* int i;
        double sum = 0;
        for( i=1;i<=20;i++)
        {
            double tmp = ((double)i)/((double)(2*i-1));
            sum +=tmp;
        }
        System.out.println(sum);*/

        //caml20();
        System.out.println("结果是：" + foo(30));
        String[] arr = {"a", "b", "c", "d", "f"};
        String[] newArr = reverseArray(arr);
        for (int i = 0; i < newArr.length ; i++) {
            System.out.println(newArr[i]);
        }



    }

    /**
     * 反转数组
     *
     * @param Array
     * @return
     */
    public static String[] reverseArray(String[] array) {
        String[] newArray = new String[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[array.length - i - 1];
        }
        return newArray;
    }

    public static int foo(int i) {
        if (i <= 0) {
            return 0;
        } else if (i > 0 && i <= 2) {
            return 1;
        }
        return foo(i - 1) + foo(i - 2);
    }

    /**
     * 1+2/3+3/5+4/7+5/9…的前20项的和
     */
    private static void caml20() {
        double sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum = sum + i / (2.0 * i - 1);
        }
        System.out.println(sum);
    }

    /**
     * 3个白球 3个红球 6个黑球 随机拿出8个球，算出所有结果
     */
    private static void camlBall8() {
        int a = 3, b = 3, c = 6, i = 0;
        for (int x = 0; x <= a; x++) {
            for (int y = 0; y <= b; y++) {
                for (int z = 0; z <= c; z++) {
                    if (x + y + z == 8) {
                        System.out.println("红球 " + x + "\t白球 " + y + "\t黑球 " + z);
                        i++;
                    }
                }
            }
        }
        System.out.println("有" + i + "结果");
    }

    /**
     * 方式二
     * 编写一个Java程序,计算并输出算式1-1/2+1/3-1/4+.......+1/99-1/100 的结果
     *
     * @param
     */
    private static double calc(int n) {
        if (n == 1) {
            return 1 / 1.d;
        } else {
            return Math.pow(-1, n - 1) * 1.d / n + calc(n - 1);
        }
    }

    /**
     * 编写一个Java程序,计算并输出算式1-1/2+1/3-1/4+.......+1/99-1/100 的结果
     *
     * @param
     */
    private static void camlFenfu() {
        double a = 1.0;
        // 接收最后结果
        double sum = 0.0;

        // 循环 i的值从1-100
        for (int i = 1; i <= 100; i++) {
            // 观察算式，分母是偶数时，分数为负
            if (i % 2 == 0) {
                sum += -(a / i);
            } else {
                sum += (a / i);
            }
        }
        System.out.println(sum);
    }

    /**
     * JAVA计算 1/1+1/2+1/3+...+1/100 的值
     *
     * @param m
     * @return
     */
    public static double getSum(int m) {
        double sum = 0;
        for (int i = 1; i <= m; i++) {
            sum += 1.0 / i;
        }

        return sum;
    }

    /**
     * 7,计算运算式1+1*2+1*2*3+1*2*3*4+……+1*2*3*4*……*20的结果并输出.
     */
    public static void jieChen20() {
        long sum = 1;
        long a = 1;
        for (int i = 2; i <= 20; i++) {
            a *= i;
            sum += a;
        }
        System.out.println(sum);
    }

    /**
     * java计算运算式1+1*2+1*2*3+1*2*3*4+……+1*2*3*4*……*20的结果并输出.
     */
    private static void camlJieChen01() {
        long sum = 1;//求和变量
        long temp = 1;//临时变量 计算n1*n2*n..
        for (long i = 1; i <= 20; i++) {
            for (long j = 1; j < i + 1; j++) {
                temp *= j;
            }
            sum += temp;
            temp = 1;
        }
        System.out.println(sum);
    }

    /**
     * Java编程题使用for循环计算1-2+3-4+...-100
     */
    private static void caml100() {
        int sum = 1;
        for (int i = 2; i <= 100; i++) {
            if (i % 2 != 0) {
                sum += i;
            } else {
                sum -= i;
            }
        }
        System.out.println(sum);
    }

    /**
     * 编程递归实现1+2+3+4+……+100
     *
     * @param number
     * @return
     */
    public static int calculate(int number) {
        int result = 0;
        if (number == 1) {
            result = 1;
        } else {
            result = number + calculate(number - 1);
        }
        return result;
    }

    /**
     * 一个猴子摘了一堆桃子，第一天吃了桃子的一半后又吃了一个，第二天也吃了剩下的桃子的一半后又吃了一个，
     * 以此吃下去，到了第十天还剩下一个桃子，问当初猴子总摘了多少个桃子？提示：倒推计算！
     */
    private static void houziMeet() {
        int sum = 0, remain = 1;
//每天吃剩的桃子加一个正好是前一天桃子的一半，每天桃子的总数就是前一天剩下桃子的数量
        for (int day = 9; day >= 1; day--) {
            sum = (remain + 1) * 2;
            remain = sum;
            System.out.println("第" + day + "天还剩" + remain + "个桃子");
        }
        //1534
        System.out.println(sum);
    }

    public static long fun(int s) {
        if (s == 0 || s == 1) {
            return 1;
        } else {
            return fun(s - 1) + fun(s - 2);
        }
    }

    /**
     * N个阶梯，一次可以上一阶或是两阶，走上去共有多少种走法？
     *
     * @param s
     * @return
     */
    public static long fun2(int s) {
        long result_1[] = new long[s + 1];//注意这个要大一个，多了个第0个
        result_1[0] = result_1[1] = 1;
        for (int i = 2; i <= s; i++) {
            result_1[i] = result_1[i - 1] + result_1[i - 2];
        }
        return result_1[s];//s就是第s+1个
    }

    /**
     * ，找出一个数组中字符出现的次数，map输出
     */
    private static void method_02() {
        String[] arr = new String[]{"aaa", "bbb", "ccc", "ddd", "ddd", "aaa"};
        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            Integer num = map.get(str);
            map.put(str, num == null ? 1 : num + 1);
        }
        for (String mp : map.keySet()) {
            System.out.println("key " + mp + " 出现次数 : " + map.get(mp));
        }
    }

    private static void method_01() {
        String[] arr = {"a", "c", "a", "d", "f", "c", "a"};
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String tem : arr) {
            String value_key = tem;
            Integer count = map.get(value_key);
            if (count != null) {
                count += 1; //如果作为key的字符前面已经出现过，则出现次数count加1
            } else {
                count = 1;
            }
            map.put(tem, count);
        }
        for (String m : map.keySet()) {
            System.out.println("key: " + m + " value: " + map.get(m));
        }
        // System.out.println(map);
    }
}
