package com.mark.testClass;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * @Author: 胡东辉
 * @Description:
 * @Date: 2019/10/11 17:05
 * @Version: 1.0
 */
@Slf4j
public class TestTimeInfo {

    public static void main(String[] args) throws Exception {

        Integer date = LocalDate.now().getDayOfWeek().getValue();
        System.out.println("weekDay:"+date);
        String [] arr ={""};
        arr[0]= "13818249475";
        System.out.println(arr[0]);

//        try {
           // showInfo(10);
            //haha(89);
//        }catch (Exception ex){
//            log.error("出错啦："+ex);
//        }

    }

    public static void showInfo(int divNumber) throws Exception {
        try {
            divNumber = divNumber / 0;
        }catch (Exception ex){
            log.error("二数相除报错："+ex);
            throw new Exception(ex);
        }
    }

    public static void haha(int divNumber) throws Exception {
        try {
            divNumber = divNumber / 0;
        }catch (Exception ex){
            log.error("除报错222："+ex);
            throw new Exception(ex);
        }
    }

}
