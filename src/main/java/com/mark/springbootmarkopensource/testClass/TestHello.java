package com.mark.springbootmarkopensource.testClass;

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
    }

    static int total(int day){
        if(day == 10){
            return 1;
        }
        else{
            return (total(day+1)+1)*2;
        }
    }
}



