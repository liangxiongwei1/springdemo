package com.example.springboot1.websocketClient;

import com.alibaba.fastjson.JSONObject;

import java.net.URISyntaxException;

/**
 * @author liang.xiongwei
 * @Title: Testmain
 * @Package com.intellif.smart
 * @Description
 * @date 2018/12/3 9:36
 */
public class Testmain {
    public static void main(String[] args) {
        try {
            WebClientEnum.CLIENT.initClient(new MsgWebSocketClient("ws://192.168.31.238:25012"));
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("header", "8");
            jsonObject.put("status", "online");
            jsonObject.put("macAddress", "1111");
            WebClientEnum.getSocketClient().send(jsonObject.toJSONString());

//            JSONObject jsonObject1 = new JSONObject();
//            jsonObject1.put("header", "3");
//            jsonObject1.put("macAddress", "1111");
//            jsonObject1.put("cbId",0);
//            jsonObject1.put("deletionId",0);
//            WebClientEnum.getSocketClient().send(jsonObject1.toJSONString());

            JSONObject test = new JSONObject();

            test.put("header",7);
            test.put("macAddress","dhjoasldj89asda");
            test.put("version","v333");
            test.put("algVersion","5035");
            test.put("snapThreshold","0.92");
            WebClientEnum.getSocketClient().send(test.toJSONString());
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
