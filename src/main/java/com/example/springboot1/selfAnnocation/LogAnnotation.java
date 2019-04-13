package com.example.springboot1.selfAnnocation;

import java.lang.annotation.*;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: LogAnnotation
 * @Package com.example.springboot1.selfAnnocation
 * @Description
 * @date 2018/8/21 20:52
 */
//自定义注解相关设置
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String desc() default "无描述消息";
}
