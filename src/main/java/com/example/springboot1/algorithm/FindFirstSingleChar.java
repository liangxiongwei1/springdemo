package com.example.springboot1.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: FindFirstSingleChar
 * @Package com.example.springboot1.algorithm
 * @Description 查找字符串只出现一个的第一个字符串
 * @date 2018/9/18 17:16
 */
public class FindFirstSingleChar {

    public Character getChar(String str){
        Map<Object ,Object> map = new HashMap<>();

        Character result = null;
        char[] chars = str.toCharArray();
        for(int i = 0; i<chars.length;i++){
            if(!map.containsKey(chars[i])){
                map.put(chars[i],i);
            }else{
                if( map.get(chars[i]) != ""){
                    map.put(chars[i],"");
                }
            }
        }
        return result;
    }
}
