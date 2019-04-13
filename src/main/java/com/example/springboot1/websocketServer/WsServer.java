package com.example.springboot1.websocketServer;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;


/**
 * @author liang.xiongwei
 * @Title: WsServer
 * @Package com.example.springboot1.websocketServer
 * @Description
 * @date 2018/12/3 14:00
 */
public class WsServer extends WebSocketServer{
    public WsServer(int port) {
        super(new InetSocketAddress(port));
    }

    public WsServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        // ws连接的时候触发的代码，onOpen中我们不做任何操作

    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        //断开连接时候触发代码
        userLeave(conn);
        System.out.println(reason);
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println(message);
        if(null != message &&message.startsWith("online")){
            String userName=message.replaceFirst("online", message);//用户名
            WsPool.sendMessageToUser(conn,userName);
            userJoin(conn,userName);//用户加入
        }else if(null != message && message.startsWith("offline")){
            userLeave(conn);
            WsPool.sendMessageToAll(message);
        }

    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        //错误时候触发的代码
        System.out.println("on error");
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        System.out.println("启动");
    }

    /**
     * 去除掉失效的websocket链接
     * @param conn
     */
    private void userLeave(WebSocket conn){
        WsPool.removeUser(conn);
    }
    /**
     * 将websocket加入用户池
     * @param conn
     * @param userName
     */
    private void userJoin(WebSocket conn,String userName){
        WsPool.addUser(userName, conn);
    }

    public static void main(String args[]){
        int port = 8887; // 端口
        WsServer s = new WsServer(port);
        s.start();
    }

}
