package com.mark.springbootmarkopensource.bean.java8;

import java.math.BigDecimal;

/**
 * ClassName:Out
 * Package:com.mark.springbootmarkopensource.bean.java8
 * Description:
 *
 * @Date:2019/3/24 0024 9:31
 * @Author: mark
 */
public class InnerOut {
    private static int a = 2;
    private int b;
    private int age = 12;


    public static class Work {
        public static void showWork() {
            System.out.println("内部静态类开始工作啦！~");
        }

    }

    abstract class TestAvb {
        void aVoidInfo() {
            System.out.println("调用内部抽象类的方法啦");
        }
    }

    public class Inner implements SubFirst {
        private int age = 13;

        public void print() {
            b = 1;
            System.out.println(a);
            System.out.println(b);
            int age = 14;
            System.out.println("局部变量：" + age);
            System.out.println("内部类变量：" + this.age);
            System.out.println("外部类变量：" + InnerOut.this.age);
            System.out.println("接口中的常量d: " + d);
            System.out.println("接口中的常量number: " + number);
        }

        @Override
        public void showInterface() {
            System.out.println("===========内部类实现内部接口测试===showInterface========");
        }
    }

    interface SubFirst {
        Integer number = 25;
        int d = 10;

        void showInterface();
    }

    public static void main(String[] args) {
      /*  InnerOut ot = new InnerOut();
        InnerOut.Inner inner = ot.new Inner();
        inner.print();
        inner.showInterface();
        InnerOut.Work.showWork();
        InnerOut.TestAvb testAvb = ot.new TestAvb() {
            @Override
            void aVoidInfo() {
                //super.aVoidInfo();
                System.out.println("重写内部类的抽象类方法");
            }
        };
        testAvb.aVoidInfo();
*/
        System.out.println("==================" + calculateCost(2, new BigDecimal(10.5)));
    }

    public static BigDecimal calculateCost(Integer itemQuantity, BigDecimal itemPrice) {
        BigDecimal itemCost = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;
        itemCost = itemPrice.multiply(new BigDecimal(itemQuantity));
        totalCost = totalCost.add(itemCost);
        return totalCost;
    }

}