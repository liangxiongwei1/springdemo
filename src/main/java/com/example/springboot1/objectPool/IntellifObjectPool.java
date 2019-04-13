//package com.example.springboot1.objectPool;
//
//import org.apache.commons.pool2.impl.GenericObjectPool;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//
//import java.util.HashMap;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * @author liang.xiongwei
// * @version V1.5.0-weixinApp
// * @Title: IntellifObjectPool
// * @Package com.example.springboot1.objectPool
// * @Description
// * @date 2018/11/12 15:29
// */
//public class IntellifObjectPool<T> {
//    private static ConcurrentHashMap<String,GenericObjectPool> poolSet = new ConcurrentHashMap<>();
//    private String poolName;
//    private int maxTotal;
//    private GenericObjectPool<T> genericObjectPool;
//    private Class<T> tClass;
//    private T obj;
//
//    public IntellifObjectPool(String poolName,Integer maxTotal,T obj) throws ClassNotFoundException {
//        if(IntellifObjectPool.poolSet.get(poolName)!=null){
//            this.genericObjectPool = poolSet.get(poolName);
//        }else {
//            GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
//            conf.setMaxTotal(maxTotal);
//            conf.setTestOnBorrow(false);
//            conf.setTestOnReturn(true);
//            conf.setTestWhileIdle(true);
//            conf.setMaxIdle(maxTotal);
//            conf.setMaxWaitMillis(300);
//            this.maxTotal = maxTotal;
//            this.genericObjectPool = new GenericObjectPool(new IntellifObjectPoolFactory(tClass), conf);
//        }
//    }
//
//    public String getPoolName() {
//        return poolName;
//    }
//
//    public void setPoolName(String poolName) {
//        this.poolName = poolName;
//    }
//
//    public int getMaxTotal() {
//        return maxTotal;
//    }
//
//    public void setMaxTotal(int maxTotal) {
//        this.maxTotal = maxTotal;
//    }
//
//    public GenericObjectPool<T> getGenericObjectPool() {
//        return genericObjectPool;
//    }
//
//    public void setGenericObjectPool(GenericObjectPool<T> genericObjectPool) {
//        this.genericObjectPool = genericObjectPool;
//    }
//
//    public Class<T> gettClass() {
//        return tClass;
//    }
//
//    public void settClass(Class<T> tClass) {
//        this.tClass = tClass;
//    }
//}
