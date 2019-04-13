package com.example.springboot1.annotation;

import java.lang.annotation.*;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: MyLog
 * @Package com.example.springboot1.annotation
 * @Description
 * @date 2018/9/19 15:32
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    String value();
}
