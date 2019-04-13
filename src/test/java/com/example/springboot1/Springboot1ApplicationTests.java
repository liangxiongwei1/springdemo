package com.example.springboot1;

import com.example.springboot1.util.HttpClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot1ApplicationTests {
    @Autowired
    HttpClientUtil httpClientUtil;

    @Test
    public void contextLoads() {
        String msg = httpClientUtil.httpGet("http://192.168.11.124:8083/api/intellif/camera/1384","bearer f4c1be12-e7b3-4bb8-b2f8-bf75fd2eae65");
        System.out.println("httpGet"+msg);

//        String msg1 = httpClientUtil.httpPost("http://192.168.11.124:8083/api/intellif/camera/page/1/pagesize/3","bearer f4c1be12-e7b3-4bb8-b2f8-bf75fd2eae65","{\"status\":-1}");
//        System.out.println("httpPost"+msg1);
//
//        String msg2 = httpClientUtil.sendPost("http://192.168.11.124:8083/api/intellif/camera/page/1/pagesize/3","{\"status\":-1}","bearer f4c1be12-e7b3-4bb8-b2f8-bf75fd2eae65");
//        System.out.println("sendPost"+msg2);
    }

}
