//package com.example.springboot1.redisQueue;
//
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//
///**
// * @author liang.xiongwei
// * @version V1.0
// * @Title: SubscriberConfig
// * @Package com.example.springboot1.redisQueue
// * @Description
// * @date 2018/9/5 17:10
// */
//
//@Configuration
//@AutoConfigureAfter({Receiver.class})
//public class SubscriberConfig {
//
//    /**
//     * 消息监听适配器，注入接受消息方法，输入方法名字 反射方法
//     *
//     * @param receiver
//     * @return
//     */
//    @Bean
//    public MessageListenerAdapter getMessageListenerAdapter(Receiver receiver) {
//        //当没有继承MessageListener时需要写方法名字
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }
//
//    /**
//     * 创建消息监听容器
//     *
//     * @param redisConnectionFactory
//     * @param messageListenerAdapter
//     * @return
//     */
//    @Bean
//    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
//        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
//        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic("TOPIC_USERNAME"));
//        return redisMessageListenerContainer;
//    }
//}