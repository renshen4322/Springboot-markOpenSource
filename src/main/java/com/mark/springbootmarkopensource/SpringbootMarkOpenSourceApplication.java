package com.mark.springbootmarkopensource.springbootmarkopensource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableScheduling
@MapperScan("com.mark.springbootmarkopensource.mapper")
@SpringBootApplication
public class SpringbootMarkOpenSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMarkOpenSourceApplication.class, args);
    }

}
