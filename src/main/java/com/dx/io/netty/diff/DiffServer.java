package com.dx.io.netty.diff;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Netty处理同一个端口上来的多条不同协议的数据
 *
 * @author : dengxu
 * @create 2019-11-01 11:23
 **/
public class DiffServer {

    public static void main(String[] args) throws Exception {

        //1 用于接受客户端连接的线程工作组
        EventLoopGroup boss = new NioEventLoopGroup();

        //ONE:
        //2 用于对接受客户端连接读写操作的线程工作组
        EventLoopGroup work = new NioEventLoopGroup();

        //TWO:
        //3 辅助类。用于帮助我们创建NETTY服务
        ServerBootstrap b = new ServerBootstrap();
//        b.group(boss, work)    //绑定两个工作线程组
//                .channel(NioServerSocketChannel.class)    //设置NIO的模式
//                .option(ChannelOption.SO_BACKLOG, 1024 * 2)    //设置TCP缓冲区
//                //.option(ChannelOption.SO_SNDBUF, 32*1024)    // 设置发送数据的缓存大小
//                .option(ChannelOption.SO_RCVBUF, 32 * 1024 * 2 * 2)
//                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)    // 设置保持连接
//                .childOption(ChannelOption.SO_SNDBUF, 32 * 1024)
//                // 初始化绑定服务通道
//                .childHandler(new InitHandler());
        //b.option("receiveBufferSizePredictorFactory", new FixedReceiveBufferSizePredictorFactory(65535));
        ChannelFuture cf = b.bind(8765).sync();

        //释放连接
        cf.channel().closeFuture().sync();
        work.shutdownGracefully();
        boss.shutdownGracefully();

    }
}
