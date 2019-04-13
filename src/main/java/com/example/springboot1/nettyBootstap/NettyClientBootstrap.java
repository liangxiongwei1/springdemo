package com.example.springboot1.nettyBootstap;

import com.example.springboot1.socket.EchoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author liang.xiongwei
 * @Title: NettyClientBootstrap
 * @Package com.example.springboot1.nettyBootstap
 * @Description
 * @date 2018/12/13 11:36
 */
public class NettyClientBootstrap {
    private int port;
    private String host;
    private SocketChannel socketChannel;
    public NettyClientBootstrap(int port, String host) throws Exception {
        this.host = host;
        this.port = port;
        start();
    }
    private void start() throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.option(ChannelOption.TCP_NODELAY, true);
        bootstrap.group(eventLoopGroup);
        bootstrap.remoteAddress(this.host, this.port);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new StringEncoder(Charset.forName("utf-8")));
                socketChannel.pipeline().addLast(new NettyClientHandler());
                socketChannel.pipeline().addLast(new ByteArrayEncoder());
                socketChannel.pipeline().addLast(new ChunkedWriteHandler());
            }
        });
        ChannelFuture future = bootstrap.connect(this.host, this.port).sync();
        if (future.isSuccess()) {
            socketChannel = (SocketChannel) future.channel();
            System.out.println("connect server  success|");
        }
    }
    public int getPort() {
        return this.port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    public SocketChannel getSocketChannel() {
        return socketChannel;
    }
    public void setSocketChannel(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }


    public static void main(String[] args) throws Exception {
        NettyClientBootstrap bootstrap = new NettyClientBootstrap(7777,"112.74.178.87");
        int i = 1;
//        SocketChannel socketChannel = SocketChannel.open();
//        socketChannel.connect(new InetSocketAddress("http://example.com", 80));
//        ByteBuffer buf = ByteBuffer.allocate(48);
//        buf.clear();
//        buf.put("111".getBytes());

//        buf.flip();
//        while (true) {
//            Map<String,Object> map = new HashMap<>();
//            map.put("test"+i,System.currentTimeMillis());
//            bootstrap.getSocketChannel().writeAndFlush(Unpooled.copiedBuffer(" {\"command\":1,\"commandId\":0,\"data\":{\"appVersion\":\"1.0\",\"deviceCode\":\"YTLF001\",\"time\":1544669893057,\"version\":\"1.0\"},\"deviceCode\":\"9527\",\"resource\":\"heartbeat\"}\n" +
//                    "SocketClient: receive {\"code\":\"0\",\"commandId\":0,\"deviceCode\":\"YTLF001\",\"msg\":\"heartbeat\"}", CharsetUtil.UTF_8)); // 必须有flush
//            i++;
//        }
    }
}
