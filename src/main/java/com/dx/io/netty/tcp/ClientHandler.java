package com.dx.io.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

public class ClientHandler extends ChannelInboundHandlerAdapter {


    private final ByteBuf firstMessage;

    public ClientHandler(){
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    //当客户端与服务端TCP链路简历成功后，Netty的NIO线程会调用该方法，发送查询时间的指令给服务器
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //将请求消息发送给服务端
        ctx.writeAndFlush(firstMessage);
    }

    //当服务器返回应答消息时，该方法被调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端开始读取数据…………");
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("Now is :" + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //释放资源
        ctx.close();
    }
}
