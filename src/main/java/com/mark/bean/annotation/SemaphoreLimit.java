package com.mark.bean.annotation;

import java.lang.annotation.*;

/**
 * Description:
 *
 * @Date:2022/8/5 12:31
 * @Author:
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SemaphoreLimit {
    String key(); //建议设置不然可能发生,不同方法重复限流现象
    int limit() default 10;

    int blockingTime() default 3;

}
