package com.example.springboot1.util;

import java.math.BigDecimal;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: BigDecimalUtils
 * @Package com.example.springboot1.util
 * @Description
 * @date 2018/9/20 8:49
 */
public class BigDecimalUtils {
    /**相加*/
    public String add(String a , String b){
        BigDecimal bigDecimalForA = new BigDecimal(a);
        BigDecimal bigDecimalForB = new BigDecimal(b);
        return bigDecimalForA.add(bigDecimalForB).toString();
    }

    /**相减*/
    public String subtract(String a , String b){
        BigDecimal bigDecimalForA = new BigDecimal(a);
        BigDecimal bigDecimalForB = new BigDecimal(b);
        return bigDecimalForA.subtract(bigDecimalForB).toString();
    }

    /**相乘*/
    public String multiply(String a , String b){
        BigDecimal bigDecimalForA = new BigDecimal(a);
        BigDecimal bigDecimalForB = new BigDecimal(b);
        return bigDecimalForA.multiply(bigDecimalForB).toString();
    }

    /**相除*/
    public String divide(String a , String b){
        BigDecimal bigDecimalForA = new BigDecimal(a);
        BigDecimal bigDecimalForB = new BigDecimal(b);
        return bigDecimalForA.divide(bigDecimalForB).toString();
    }
}
