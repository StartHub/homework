package com.dx.io.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class SimpleHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("开始读取数据…………");
        if(msg instanceof ByteBuf){

            //将msg转换成Netty的ByteBuf对象
            ByteBuf buf = (ByteBuf) msg;

            //将缓冲区中的字节数组复制到新建的byte数组中，
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);

            //获取请求消息
            String body = new String(req,"UTF-8");
            System.out.println("The time server receive order:" + body);

            //如果是"QUERY TIME ORDER"则创建应答消息
            String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(System.currentTimeMillis()).toString() : "BAD ORDER";

            ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());

            //异步发送应答消息给客户端
            ctx.write(resp);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
