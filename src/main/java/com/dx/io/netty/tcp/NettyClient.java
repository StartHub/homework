package com.dx.io.netty.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.boot.convert.Delimiter;

import java.nio.charset.Charset;

public class NettyClient {

    public static void main(String[] args) {

        //创建客户端处理I/O读写的NioEventLoopGroup Group线程组
        EventLoopGroup group = new NioEventLoopGroup();

        try {

            //创建客户端辅助启动类Bootstrap
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class)
                    .group(group)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<NioSocketChannel>() {

                        //将ChannelHandler设置到ChannelPipleline中，用于处理网络I/O事件
                        @Override
                        protected void initChannel(NioSocketChannel channel) throws Exception {
//                            channel.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
//                            channel.pipeline().addLast(new StringEncoder());
                            channel.pipeline().addLast(new ClientHandler());
                        }
                    });

            //发起异步连接操作，然后调用同步方法等待连接成功。
            ChannelFuture future = bootstrap.connect("localhost", 8080).sync();
//            String p = "张三/r/n";
//            future.channel().writeAndFlush(p);

            //等待客户端链路关闭
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
