//package com.example.springboot1.objectPool;
//
//import org.apache.commons.pool2.BasePooledObjectFactory;
//import org.apache.commons.pool2.PooledObject;
//import org.apache.commons.pool2.PooledObjectFactory;
//import org.apache.commons.pool2.impl.DefaultPooledObject;
//
//import java.util.Random;
//
///**
// * @author liang.xiongwei
// * @version V1.5.0-weixinApp
// * @Title: IntellifObjectPoolFactory
// * @Package com.example.springboot1.objectPool
// * @Description
// * @date 2018/11/12 15:30
// */
//public class IntellifObjectPoolFactory<T>implements PooledObjectFactory<T> {
//
//    private Class<T> tClass;
//    private T obj;
//
//    @Override
//    public PooledObject<T> wrap(T t) {
//        return null;
//    }
//
//    @Override
//    public PooledObject<T> makeObject() throws Exception {
//        return new DefaultPooledObject(this.obj);
//    }
//
//    @Override
//    public void destroyObject(PooledObject pooledObject)
//            throws Exception {
//    }
//
//    @Override
//    public boolean validateObject(PooledObject pooledObject) {
//        //默认是false,代表验证不通过,这里随机好了
//        return new Random().nextInt()%2==0;
//    }
//
//    @Override
//    public void activateObject(PooledObject pooledObject)
//            throws Exception {
//    }
//
//    @Override
//    public void passivateObject(PooledObject pooledObject)
//            throws Exception {
//    }
//}
