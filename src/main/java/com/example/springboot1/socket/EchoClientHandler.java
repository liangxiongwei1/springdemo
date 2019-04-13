package com.example.springboot1.socket;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liang.xiongwei
 * @Title: EchoClientHandler
 * @Package com.example.springboot1.socket
 * @Description
 * @date 2018/12/11 15:11
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {


    /**
     * 向服务端发送数据
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端与服务端通道-开启：" + ctx.channel().localAddress() + "channelActive");

        String sendInfo = "Hello 这里是客户端  你好啊！";
        System.out.println("客户端准备发送的数据包：" + sendInfo);

        Map<String,Object> map = new HashMap<>();
        map.put("command",1);
        map.put("commandId",0);
        map.put("deviceCode","YTLF001");
        map.put("resource","heartbeat");
        Map<String,Object> data = new HashMap<>();
        data.put("deviceCode","YTLF001");
        data.put("time",System.currentTimeMillis());
        data.put("appVersion","1.0");
        data.put("version","1.0");
        map.put("data",data);
        System.out.println("客户端准备发送的数据包：" + JSONObject.toJSONString(map));
//        ctx.writeAndFlush(Unpooled.copiedBuffer( JSONObject.toJSONString(map), CharsetUtil.UTF_8));
        ctx.writeAndFlush(Unpooled.copiedBuffer(" {\"command\":1,\"commandId\":0,\"data\":{\"appVersion\":\"1.0\",\"deviceCode\":\"YTLF001\",\"time\":1544669893057,\"version\":\"1.0\"},\"deviceCode\":\"9527\",\"resource\":\"heartbeat\"}\n" +
                "SocketClient: receive {\"code\":\"0\",\"commandId\":0,\"deviceCode\":\"YTLF001\",\"msg\":\"heartbeat\"}", CharsetUtil.UTF_8)); // 必须有flush
        ctx.writeAndFlush(Unpooled.copiedBuffer(" {\"command\":1,\"commandId\":0,\"data\":{\"appVersion\":\"1.0\",\"deviceCode\":\"YTLF001\",\"time\":1544669893057,\"version\":\"1.0\"},\"deviceCode\":\"9527\",\"resource\":\"heartbeat\"}\n" +
                "SocketClient: receive {\"code\":\"0\",\"commandId\":0,\"deviceCode\":\"YTLF001\",\"msg\":\"heartbeat\"}", CharsetUtil.UTF_8)); // 必须有flush
    }

    /**
     * channelInactive
     *
     * channel 通道 Inactive 不活跃的
     *
     * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
     *
     */
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端与服务端通道-关闭：" + ctx.channel().localAddress() + "channelInactive");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("读取客户端通道信息..");
        ByteBuf buf = msg.readBytes(msg.readableBytes());
        System.out.println(
                "客户端接收到的服务端信息:" + ByteBufUtil.hexDump(buf) + "; 数据包为:" + buf.toString(Charset.forName("utf-8")));
        ctx.writeAndFlush(Unpooled.copiedBuffer(" {\"command\":1,\"commandId\":0,\"data\":{\"appVersion\":\"1.0\",\"deviceCode\":\"YTLF001\",\"time\":1544669893057,\"version\":\"1.0\"},\"deviceCode\":\"9527\",\"resource\":\"heartbeat\"}\n" +
                "SocketClient: receive {\"code\":\"0\",\"commandId\":0,\"deviceCode\":\"YTLF001\",\"msg\":\"heartbeat\"}", CharsetUtil.UTF_8)); // 必须有flush
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        System.out.println("异常退出:" + cause.getMessage());
    }
}
