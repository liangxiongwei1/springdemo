package com.example.springboot1.util;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: KafkaReceiver
 * @Package com.example.springboot1.util
 * @Description
 * @date 2018/8/28 20:23
 */
@Component("KafkaReceiver")
public class KafkaReceiver {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public static Map<String, String> resultMap = new HashMap<String, String>(); //储存读取kafka的消息

    //门禁消息推送
    @KafkaListener(topics = {"community-test"})
    public void accessListener(ConsumerRecord<?, ?> record) {
        String jsonString = (String) record.value();
        logger.info("------***收到消息,topic:" + record.topic() + ",Key:" + record.key() + ",Value:" + record.value());
        //JSONArray dataArr = JSONArray.parseArray(alarmStr);
    }
}
