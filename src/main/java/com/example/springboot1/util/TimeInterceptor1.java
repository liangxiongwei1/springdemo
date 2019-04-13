package com.example.springboot1.util;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: TimeInterceptor1
 * @Package com.example.springboot1.util
 * @Description
 * @date 2018/9/30 16:25
 */
@Component
public class TimeInterceptor1 implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("time filter 耗时："+(System.currentTimeMillis()-start));
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
