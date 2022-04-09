package com.mark.springbootmarkopensource.bean.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {
    String originate();
    String community();
}
