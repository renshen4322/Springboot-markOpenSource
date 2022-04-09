package com.mark.springbootmarkopensource.testClass;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: 胡东辉
 * @Description:
 * @Date: 2019/10/28 21:09
 * @Version: 1.0
 */
public class TestUserJWT {
    public static void main(String[] args) throws Exception {
        System.out.println("dat1==="+ZonedDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0));
        System.out.println("dat2==="+ZonedDateTime.now().withHour(0).withMinute(0).withSecond(0));
        //ZonedDateTime  startTime = toZonedDateInfo(ZonedDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0).toString(),0);

        System.out.println(""+ZonedDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0));
        System.out.println(""+ZonedDateTime.now().withHour(0).withMinute(0).withSecond(0));

//        System.out.println("=============================");
//        System.out.println(toZonedDateTime("2019-10-24T16:00:00.000Z"));
//        System.out.println("text===="+toTime(new Date()));
//        System.out.println("31===="+toZonedDateTime("2019-10-31T16:00:00.000Z"));
//
//        System.out.println("31T====="+getZoneDateTime("2019-10-31T16:00:00.000Z"));
    }

    public static ZonedDateTime toTime(Date utilDate){
        if (utilDate == null) {
            return null;
        }
        final ZoneId systemDefault = ZoneId.systemDefault();
        return ZonedDateTime.ofInstant(utilDate.toInstant(), systemDefault);
    }

    public static ZonedDateTime toZonedDateInfo(String time,int dayTime){
        String date = time;
        date = date.replace("Z", " UTC");
        System.out.println(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date utilDate = null;
        try {
            utilDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(utilDate);
        ca.add(Calendar.HOUR, dayTime);
        Date utilDate2 =ca.getTime();
        if (utilDate2 == null) {
            return null;
        }
        final ZoneId systemDefault = ZoneId.systemDefault();
        return ZonedDateTime.ofInstant(utilDate2.toInstant(), systemDefault);
    }

    private static  ZonedDateTime toZonedDateTime(String time) {
        String date = time;
        date = date.replace("Z", " UTC");
        System.out.println(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date utilDate = null;
        try {
            utilDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (utilDate == null) {
            return null;
        }
        final ZoneId systemDefault = ZoneId.systemDefault();
        return ZonedDateTime.ofInstant(utilDate.toInstant(), systemDefault);
    }

    public static String getTimeChangeStr(Date dt) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(dt);//格式化数据
        return date;
    }

    /**
     * 某个时间延后n天
     *
     * @param time
     * @param dayTime
     * @return
     */
    public static String getTimeDelayedForHour(Date time, int dayTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(getTimeChangeStr(time));
        } catch (ParseException e) {

            e.printStackTrace();
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.HOUR, dayTime);
        return sdf.format(ca.getTime());
    }
    public static Date getExchangeTime(String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(time);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return date;
    }

    public static ZonedDateTime getZoneDateTime(String time){
        String date = time;
        date = date.replace("Z", " UTC");
        System.out.println(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date utilDate = null;
        try {
            utilDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(utilDate);
        ca.add(Calendar.HOUR, -8);
        Date utilDate2 =ca.getTime();
        if (utilDate2 == null) {
            return null;
        }
        final ZoneId systemDefault = ZoneId.systemDefault();
        return ZonedDateTime.ofInstant(utilDate2.toInstant(), systemDefault);
    }

}
