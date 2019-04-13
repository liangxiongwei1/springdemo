package com.example.springboot1.websocketClient;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author liang.xiongwei
 * @Title: MsgWebSocketClient
 * @Package com.intellif.smart.websocketClient
 * @Description
 * @date 2018/12/1 15:57
 */
public class MsgWebSocketClient extends WebSocketClient {


    public MsgWebSocketClient(String url) throws URISyntaxException {
        super(new URI(url));
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("握手...");
    }

    @Override
    public void onMessage(String s) {
        System.out.println("接收到消息:"+s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("关闭:"+s);
    }

    @Override
    public void onError(Exception e) {
        System.out.println("异常:"+e);
    }
}
