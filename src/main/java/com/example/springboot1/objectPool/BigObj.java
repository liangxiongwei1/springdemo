package com.example.springboot1.objectPool;

/**
 * @author liang.xiongwei
 * @version V1.5.0-weixinApp
 * @Title: BigObj
 * @Package com.example.springboot1.objectPool
 * @Description
 * @date 2018/11/12 17:28
 */
public class BigObj {
    static int id = 0;
    int v;
    BigObj() {
        this.v = id++;
        System.out.println("create " + v);
    }
    public void destroy() {
        System.out.println("destroy " + v);
    }

    public int getV() {
        return v;
    }
}
