package com.example.springboot1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class Scheduler2Task {
//    @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
//    @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
//    @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    @Autowired
    RedisTemplate redisTemplate;
//    @Scheduled(fixedRate = 6000)
//    public void reportCurrentTime() {
//        long time = System.currentTimeMillis()/(60*1000);
////        Set<Map<String,Object>> set = redisTemplate.opsForZSet().rangeByScore("authorizationCache",0,time);
////        set.forEach(p->{
////            try {
////                long endTime = sf.parse(p.get("endTime").toString()).getTime()/(60*1000);
////                if(endTime>time){
////                    //授权
////                  System.out.println("ok");
////                }else{
////                    redisTemplate.opsForZSet().remove("authorizationCache",p);
////                }
////            } catch (Exception e) {
////            }
////        });
//        Set<Map<String,Object>> set = redisTemplate.opsForZSet().rangeByScore("cache",0,time);
//        set.forEach(p->{
//            Map<String,Object> map = new HashMap<>(5);
//            map.put("personId",p.get("personId"));
//            map.put("cameraIds",p.get("cameraIds"));
//            map.put("startTime",p.get("startTime"));
//            map.put("endTime",p.get("endTime"));
//            map.put("id",p.get("id"));
//            redisTemplate.opsForZSet().remove("cache",map);
//        });
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
//    }

}
