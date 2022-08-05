package com.mark.testClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splistrlist分段数据 {
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
       /* List<String> list = Arrays.asList(arr);
        list.stream().forEach(c->
                System.out.println(c)
        );*/
        //List<String> list = Arrays.asList(str.split(","));

        List<String> list = new ArrayList<String>();
        for(int i=1;i<=1000000;i++){
            list.add("fff"+i);
        }
       /* list.add("aaa");//index_0
        list.add("bbb");//index_1
        list.add("ccc");//index_2
        list.add("ddd");//index_3
        list.add("eee");//index_4
        list.add("fff");//index_5
        list.add("ggg");//index_6 */
        int flag = 50;//每次取的数据
        int size = list.size();
        int temp = size / flag + 1;
        boolean special = size % flag == 0;
        List<String> cutList = null;
        for (int i = 0; i < temp; i++) {
            if (i == temp - 1) {
                if (special) {
                    break;
                }
                cutList = list.subList(flag * i, size);
            } else {
                cutList = list.subList(flag * i, flag * (i + 1));
            }
            System.out.println("第" + (i + 1) + "组：" + cutList.toString());
        }
    }


}
