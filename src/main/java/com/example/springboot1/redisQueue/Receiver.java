//package com.example.springboot1.redisQueue;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.connection.MessageListener;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.stereotype.Component;
//
///**
// * @author liang.xiongwei
// * @version V1.0
// * @Title: Receiver
// * @Package com.example.springboot1.redisQueue
// * @Description
// * @date 2018/9/5 17:07
// */
//@Component
//public class Receiver implements MessageListener {
//    private static Logger logger = LoggerFactory.getLogger(Receiver.class);
//
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @Override
//    public void onMessage(Message message, byte[] pattern) {
//        RedisSerializer<String> valueSerializer = redisTemplate.getStringSerializer();
//        String deserialize = valueSerializer.deserialize(message.getBody());
//        String patternM = pattern.toString();
//        logger.info("收到的mq消息"+patternM + deserialize);
//    }
//
//}
