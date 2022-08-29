package com.mark.testClass;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName:TestHello
 * Package:com.mark.springbootmarkopensource.testClass
 * Description:
 *
 * @Date:2021/5/13 0013 22:58
 * @Author: mark
 */
public class TestHello {
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println(total(1));

        String str = "1180220701109226#demo_chimera-15200000002@easemob.com/android_914ecabb-1a7d-4590-a0a6-840cd4f58402";
        String tt = str.split("#")[1].split("_")[1].toString();
        System.out.println(String.format("ttttttttt=========%s", tt));
        String t2 = StringUtils.substringBetween(str, "#", "@").split("_")[1];
        System.out.println("t2==="+t2);
    }

    static int total(int day) {
        if (day == 10) {
            return 1;
        } else {
            return (total(day + 1) + 1) * 2;
        }
    }
}



