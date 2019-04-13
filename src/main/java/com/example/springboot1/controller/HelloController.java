package com.example.springboot1.controller;


//import com.example.springboot1.redisQueue.PublisherService;
import com.example.springboot1.selfAnnocation.LogAnnotation;
import com.example.springboot1.service.TestService;
import com.example.springboot1.service.impl.TestServiceImpl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

@RestController
public class HelloController {

    @Value("${test}")
    private String name;

    @Autowired
    @Qualifier("TestServiceImpl")
    TestService testService;

    @LogAnnotation(desc = "测试")
    @RequestMapping("/hello")
    public String hello(@PathVariable String param){
        return  testService.test();
    }


    @PostMapping("/abc/face.cgi")
    public String test(HttpServletRequest request, @RequestParam(name = "id") Object id,@RequestParam(name = "user") Object user){
        System.out.println(request);
        return  "ss";
    }
}
