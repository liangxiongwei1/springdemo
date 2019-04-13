package com.netty.handler;

import com.alibaba.fastjson.JSONObject;
import com.netty.bean.DefaultFuture;
import com.netty.bean.Response;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author liang.xiongwei
 * @Title: TcpClientHandler
 * @Package com.netty.handler
 * @Description
 * @date 2018/12/13 9:21
 */
@ChannelHandler.Sharable
public class TcpClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//判断服务端和客户端是在能够正常通信的情况下
        if(msg.toString().equals("ping")){
            ctx.channel().writeAndFlush("ping\r\n");
            return ;
        }
        System.out.println("客户端获取到服务端响应数据:"+msg.toString());

        String str = getJSONObject(msg.toString()).toString();
//读取服务端的响应结果
        Response res = JSONObject.parseObject(str, Response.class);
        //存储响应结果
        DefaultFuture.recive(res);
    }

    private JSONObject getJSONObject(String str){
        JSONObject json = JSONObject.parseObject(str);
        json.remove("content");
        json.put("msg","保存用户信息成功");
        return json;
    }

}

