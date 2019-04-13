package com.netty.initialzer;

import com.netty.handler.TcpClientHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author liang.xiongwei
 * @Title: TcpClientInitalizer
 * @Package com.netty.initialzer
 * @Description
 * @date 2018/12/13 9:30
 */
public class TcpClientInitalizer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //按照\r\n进行解码
        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
        ch.pipeline().addLast(new StringDecoder());
        ch.pipeline().addLast(new TcpClientHandler());
        ch.pipeline().addLast(new StringEncoder());
    }
}
