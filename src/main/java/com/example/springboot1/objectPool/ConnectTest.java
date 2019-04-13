package com.example.springboot1.objectPool;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot1.dto.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import sun.misc.Unsafe;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liang.xiongwei
 * @version V1.5.0-weixinApp
 * @Title: ConnectTest
 * @Package com.example.springboot1.objectPool
 * @Description
 * @date 2018/11/12 15:10
 */
public class ConnectTest {
        public static void main(String[] args) throws Exception {
//                Map<String,String> map = new HashMap<>();
//                map.put("a", "1");
//                map.put("b", "2");
//                map.put("c", "3");
//                map.put("d", "4");
//                map.put("e", "5");
//                List list= map.entrySet().stream().collect(Collectors.toList());
               System.out.println( System.currentTimeMillis());




//            GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
//            conf.setMaxTotal(5);
//            conf.setTestOnReturn(true);
//            GenericObjectPool<BigObj> pool = new GenericObjectPool<BigObj>(new BigObjFactory(), conf);
//            for(int i =0;i< 10; i++) {
//                BigObj bigObj = pool.borrowObject();
//                System.out.println(i + " time get " + bigObj.getV());
//                pool.returnObject(bigObj);
//            }

//         String string = "";
//         Object a = null;
//         String s = a + "";
//            StringBuffer s = new StringBuffer("");
//         System.out.println(s.length());
//            Map<String,Object> param = new HashMap<>();
//            param.put("userName","sss");
//            param.put("passWord","1111");
//            User u = JSONObject.parseObject(JSONObject.toJSONString(param), User.class);
//            System.out.println(u.getPassWord());

//
//            IntellifObjectPool<PoolTest> poolFactory  = new IntellifObjectPool("TEST",5, new PoolTest(2));
//            GenericObjectPool<PoolTest> pool = null;
//            Object o = new Object();
//            try {
//                pool = poolFactory.getGenericObjectPool();
//                for(int i =0;i<10;i++){
//                    PoolTest poolTest =pool.borrowObject();
//                    try {
//                        System.out.println(i + " time get " + poolTest.getCount());
//                    } finally {
//                    }
//                    pool.returnObject(poolTest);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }finally {
//                pool.close();
//            }

        }
}
