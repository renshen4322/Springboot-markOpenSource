package com.mark.testClass;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //0 */1 * * * ?每分
    //0/5 * * * * ? 每5秒
    @Scheduled(cron = "0 */5 * * * ?") //每五分钟
    public void reportCurrentTime() {
        System.out.println("====================================================");
        System.out.println("现在时间：" + dateFormat.format(new Date()));
        System.out.println("job跑起来！==========================================");
    }
}
