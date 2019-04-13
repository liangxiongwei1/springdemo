package com.example.springboot1.objectPool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.Random;

/**
 * @author liang.xiongwei
 * @version V1.5.0-weixinApp
 * @Title: BigObjFactory
 * @Package com.example.springboot1.objectPool
 * @Description
 * @date 2018/11/12 17:40
 */
public class BigObjFactory implements PooledObjectFactory<BigObj> {
    @Override
    public PooledObject<BigObj> makeObject() throws Exception {
        return new DefaultPooledObject<BigObj>(new BigObj());
    }

    @Override
    public void destroyObject(PooledObject<BigObj> pooledObject)
            throws Exception {
        pooledObject.getObject().destroy();
    }

    @Override
    public boolean validateObject(PooledObject<BigObj> pooledObject) {
        //默认是false,代表验证不通过,这里随机好了
        return new Random().nextInt()%2==0;
    }

    @Override
    public void activateObject(PooledObject<BigObj> pooledObject)
            throws Exception {
    }

    @Override
    public void passivateObject(PooledObject<BigObj> pooledObject)
            throws Exception {
    }
}
