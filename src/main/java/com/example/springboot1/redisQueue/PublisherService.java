//package com.example.springboot1.redisQueue;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
///**
// * @author liang.xiongwei
// * @version V1.0
// * @Title: PublisherService
// * @Package com.example.springboot1.redisQueue
// * @Description
// * @date 2018/9/5 17:05
// */
//@Service
//public class PublisherService {
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    public String sendMessage(String name) {
//        try {
//            redisTemplate.convertAndSend("TOPIC_USERNAME", name);
//            return "消息发送成功了";
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "消息发送失败了";
//        }
//    }
//
//}
