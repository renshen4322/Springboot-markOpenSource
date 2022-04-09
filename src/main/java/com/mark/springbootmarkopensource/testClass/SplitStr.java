package com.mark.springbootmarkopensource.testClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitStr {
    public static void main(String[] args) {
        List<String> weekList = Arrays.asList(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        );

        String str = weekList.stream().collect(Collectors.joining(","));
        System.out.println(str);
        System.out.println("=========*****************************====");
        String str2 = "a,b,c,d";
        String[] arr = str.split(",");
        List<String> list = Arrays.asList(arr);
        list.stream().forEach(c->
                System.out.println(c)
        );
        //List<String> list = Arrays.asList(str.split(","));

    }
}
