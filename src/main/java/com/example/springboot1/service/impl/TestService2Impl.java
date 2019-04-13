package com.example.springboot1.service.impl;

import com.example.springboot1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: TestServiceImpl
 * @Package com.example.springboot1.service.impl
 * @Description
 * @date 2018/8/21 16:14
 */
@Service("TestServicessssImpl")
public class TestService2Impl implements TestService {
    @Autowired
    static Jedis jedis;
    @Autowired
    static RedisTemplate redisTemplate;

    @Override
    public String test() {
        System.out.println("test2");
        return "test2";

    }

    public static void main(String[] args){
        Map<String,Object> param  = new HashMap<>();
        param.put("name","name1");
        param.put("password",11);
        redisTemplate.opsForValue().multiSet(param);
    }
}
