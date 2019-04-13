package com.example.springboot1.jihe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: MapClass
 * @Package com.example.springboot1.jihe
 * @Description
 * @date 2018/10/15 16:01
 */
public class MapClass {
    public static void main(String[] args){
        Map<String,Object> param = new HashMap<>();
        param.put("sss","sss");
        param.put("aaa","aaa");
//        for(String key:param.keySet()){
//            if(key.equals("aaa")){
//                param.remove("aaa");
//            }
//        }

//        Iterator<String> iterator = param.keySet().iterator();
//        while (iterator.hasNext()){
//            if(iterator.next().equals("aaa")){
//                iterator.remove();
//            }
//        }
//        param.forEach((k,v)->System.out.println(v));
//
        Map<String,Object> param1 = new Hashtable<>();
        param1.put("sss","sss");
        param1.put("aaa","aaa");
        for(String key:param1.keySet()){
            if(key.equals("aaa")){
                param1.remove("aaa");
            }
        }
//        Iterator<String> iterator1 = param1.keySet().iterator();
//        while (iterator1.hasNext()){
//            if(iterator1.next().equals("aaa")){
//                iterator1.remove();
//            }
//        }
        param1.forEach((k,v)->System.out.println(v));
        ConcurrentHashMap<String,Object> con = new ConcurrentHashMap<>();
        con.put("sss","sss");
        con.put("aaa","aaa");
        con.put("BBB","BBB");
//        con.put("CCC","CCC");
//        con.forEach((k,v)->System.out.println(v));
//        con.forEach((k,v)->{if(k.equals("CCC")){
//            con.remove("CCC");
//        }
//        });
//        con.forEach((k,v)->System.out.println(v));
HashSet<String> hashSet = new HashSet<>();
LinkedHashSet<String> hashSet1 = new LinkedHashSet<>();

        LinkedHashMap<String,Object> linkedMap = new LinkedHashMap<String,Object>(16,0.75f,true);
        linkedMap.put("sss","sss");
        linkedMap.put("aaa","aaa");
        linkedMap.put("BBB","BBB");
        linkedMap.put("CCC","CCC");
        linkedMap.forEach((k,v)->System.out.println(v));
        linkedMap.get("aaa");
        linkedMap.get("sss");
        linkedMap.forEach((k,v)->System.out.println(v));

    }


}
