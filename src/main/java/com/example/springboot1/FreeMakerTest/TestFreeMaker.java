package com.example.springboot1.FreeMakerTest;

import freemarker.template.Template;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: TestFreeMaker
 * @Package com.example.springboot1.FreeMakerTest
 * @Description
 * @date 2018/10/10 17:02
 */
public class TestFreeMaker {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(TestFreeMaker.class.getClassLoader().getResource(""));
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(TestFreeMaker.class.getResource(""));
        System.out.println(TestFreeMaker.class.getResource("/"));
        try {
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("utf-8");
            String path = ClassLoader.getSystemResource("").getPath();
            System.out.println(path);
            configuration.setDirectoryForTemplateLoading(new File(path));
            Template template = configuration.getTemplate("freeMaker.ftl");
            Map<String,String> map = new HashMap<String,String>();
//            HttpServletRequest request = (HttpServletRequest) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            String ip =  request.getLocalName()+request.getLocalPort();
            map.put("faceIP","11");
            map.put("cardIP","11");
            File file = new File("D://test.xml");
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            template.process(map, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
