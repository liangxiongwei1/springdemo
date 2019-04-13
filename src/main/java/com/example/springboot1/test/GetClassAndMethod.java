package com.example.springboot1.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: GetClassAndMethod
 * @Package com.example.springboot1.test
 * @Description
 * @date 2018/8/21 16:17
 */
public class GetClassAndMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = Class.forName("com.example.springboot1.service.impl.TestServiceImpl");
        Method m = c.getMethod("test");
        m.invoke(c.newInstance());

    }
}
