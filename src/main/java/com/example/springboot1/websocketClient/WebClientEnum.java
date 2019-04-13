package com.example.springboot1.websocketClient;

import org.java_websocket.WebSocket;

/**
 * @author liang.xiongwei
 * @Title: WebClientEnum
 * @Package com.intellif.smart.websocketClient
 * @Description
 * @date 2018/12/1 16:01
 */
public enum WebClientEnum {
    /**webClient 单例*/
    CLIENT;

    private static MsgWebSocketClient socketClient = null;

    public static MsgWebSocketClient getSocketClient() {
        return socketClient;
    }

    public static void setSocketClient(MsgWebSocketClient socketClient) {
        WebClientEnum.socketClient = socketClient;
    }

    public  static void initClient(MsgWebSocketClient client) {
        socketClient = client;
        socketClient.connect();
        if(socketClient == null) {
            socketClient.connect();
            socketClient.send("测试websocket。。。");
        }
        while(!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
            System.out.println("还没有打开");
        }
//        boolean flag = true;
//        int i=1000;
//        while(flag) {
//            socketClient.send("online:"+(i--));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            if(i == 0) {
//                flag = false;
//            }
//        }
    }
}
