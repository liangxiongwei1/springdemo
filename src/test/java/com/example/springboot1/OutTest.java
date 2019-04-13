package com.example.springboot1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: OutTest
 * @Package com.example.springboot1
 * @Description
 * @date 2018/8/21 15:05
 */
public class OutTest {
    public static void main(String[] args) throws IOException {
        StringReader a = new StringReader("src/docs/asciidoc/generated/swagger.json");
        String filepath = "src/docs/asciidoc/generated/swagger.json";
        BufferedReader read = new BufferedReader(new FileReader(filepath));
        String s;
        StringBuffer sb = new StringBuffer();
        while((s=read.readLine()) != null){
            sb.append(s+"\n");
        }
        read.close();
        System.out.println(sb);
    }
}
