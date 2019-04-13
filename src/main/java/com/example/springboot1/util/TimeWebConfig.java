package com.example.springboot1.util;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: TimeWebConfig
 * @Package com.example.springboot1.util
 * @Description
 * @date 2018/9/30 16:21
 */
public class TimeWebConfig {
    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeInterceptor1 interceptor = new TimeInterceptor1();
        registrationBean.setFilter(interceptor);
        List<String> urls = new ArrayList<>();
        urls.add("http://192.168.9.254:8080/abc/alarm.cgi");
        urls.add("http://192.168.9.254:8080/abc/card.cgi");
        urls.add("http://192.168.9.254:8080/abc/talk.cgi");
        urls.add("http://192.168.9.254:8080/abc/jpeg.cgi");
        urls.add("http://192.168.9.254:8080/abc/lock.cgi");
        urls.add("http://192.168.9.254:8080/abc/face.cgi");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }


}
