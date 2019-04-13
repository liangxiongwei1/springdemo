package com.example.springboot1;


import com.example.springboot1.util.TimeWebConfig;
import com.intellif.config.annotation.EnableAutoConfigI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableCaching
@EnableScheduling
//启用自动从配置中心获取配置
//@EnableAutoConfigI
//@EnableEurekaServer
public class Springboot1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot1Application.class, args);
    }
}