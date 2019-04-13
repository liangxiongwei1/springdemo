package com.example.springboot1.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {

    private int count=0;

//    @Scheduled(initialDelay = 1000,cron="*0 20 * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }

}