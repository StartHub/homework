package com.dx.io.netty.diff;

/**
 * @author : dengxu
 * @create 2019-11-01 11:25
 **/
//public class InitHandler extends ChannelInitializer<SocketChannel> {
//
//    final AcceptorIdleStateTrigger idleStateTrigger = new AcceptorIdleStateTrigger();
//
//    @Override
//    protected void initChannel(SocketChannel socketChannel) throws Exception {
//        ChannelPipeline pipeline = socketChannel.pipeline();
//
//        pipeline.addLast(new StringEncoder());
//        pipeline.addLast(new ByteArrayEncoder());
//
//        //自定义StringDecoder，其余的都是用的netty提供的
//        pipeline.addLast(new StringDecoder1());
//        pipeline.addLast(new ByteArrayDecoder1());
//        pipeline.addLast(new ServerHandler());
//        pipeline.addLast(new ServerHandler2());
//
//    }
//}
