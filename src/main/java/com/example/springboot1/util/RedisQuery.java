package com.example.springboot1.util;

import com.example.springboot1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author liang.xiongwei
 * @version V1.5.0-weixinApp
 * @Title: RedisQuery
 * @Package com.example.springboot1.util
 * @Description
 * @date 2018/11/5 11:42
 */
@Component
public class RedisQuery {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserDao userDao;

    public void insertData(){
        for(int i=0;i<100;i++){
            redisTemplate.opsForZSet().add("redisQuery",i,i);
            userDao.testInt((long)i);
        }
    }

    public void query(){
        Long i = System.currentTimeMillis();
        Set<Integer> set = redisTemplate.opsForZSet().range("redisQuery",0,98);
        System.out.println( "REDIS:"+(System.currentTimeMillis()-i));
        Long b = System.currentTimeMillis();
        userDao.queryTest(98L);
        System.out.println( "MYSQL:"+(System.currentTimeMillis()-b));
    }

}
