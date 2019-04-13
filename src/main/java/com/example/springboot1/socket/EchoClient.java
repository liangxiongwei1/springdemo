package com.example.springboot1.socket;

import com.alibaba.fastjson.JSONObject;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liang.xiongwei
 * @Title: EchoClient
 * @Package com.example.springboot1.socket
 * @Description
 * @date 2018/12/11 15:09
 */
public class EchoClient {
    private final String host;
    private final int port;
    private  Channel channel = null;
    public EchoClient() {
        this(0);
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public EchoClient(int port) {
        this("localhost", port);
    }

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.group(group) // 注册线程池
                    .channel(NioSocketChannel.class) // 使用NioSocketChannel来作为连接用的channel类
                    .remoteAddress(new InetSocketAddress(this.host, this.port)) // 绑定连接端口和host信息
                    .handler(new ChannelInitializer<SocketChannel>() { // 绑定连接初始化器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            System.out.println("正在连接中...");
                            ch.pipeline().addLast(new StringEncoder(Charset.forName("utf-8")));
                            ch.pipeline().addLast(new EchoClientHandler());
                            ch.pipeline().addLast(new ByteArrayEncoder());
                            ch.pipeline().addLast(new ChunkedWriteHandler());

                        }
                    });
            // System.out.println("服务端连接成功..");

            ChannelFuture cf = b.connect().sync(); // 异步连接服务器
            System.out.println("服务端连接成功..."); // 连接完成
            this.channel = cf.channel();
            cf.channel().writeAndFlush("Hello Netty Server, I am a common client");
            cf.channel().closeFuture().sync(); // 异步等待关闭连接channel
            System.out.println("连接已关闭.."); // 关闭完成

        } finally {
            group.shutdownGracefully().sync(); // 释放线程池资源
        }
    }
    public  void sendMessage(String msg) {//连接成功后，通过Channel提供的接口进行IO操作
        try {
            if (this.channel != null && this.channel.isOpen()) {
                this.channel.writeAndFlush(msg).sync();
            } else {
                throw new Exception("channel is null | closed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        EchoClient e = new EchoClient("112.74.178.87", 7777); // 连接127.0.0.1/65535，并启动
        e.start();
        Map<String,Object> map = new HashMap<>();
        map.put("command",1);
        map.put("commandId",123);
        map.put("deviceCode","YTLF001");
        map.put("resource","heartbeat");
        Map<String,Object> data = new HashMap<>();
        data.put("deviceCode","YTLF001");
        data.put("time",System.currentTimeMillis());
        data.put("appVersion","1.5.1");
        data.put("version","2.0.3");
        map.put("data",data.toString());
        e.sendMessage(" {\"command\":1,\"commandId\":0,\"data\":{\"appVersion\":\"1.0\",\"deviceCode\":\"9527\",\"time\":1544669893057,\"version\":\"1.0\"},\"deviceCode\":\"9527\",\"resource\":\"heartbeat\"}\n" +
                "SocketClient: receive {\"code\":\"0\",\"commandId\":0,\"deviceCode\":\"9527\",\"msg\":\"heartbeat\"}");

    }
}
