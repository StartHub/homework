package com.dx.io.netty.diff;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author : dengxu
 * @create 2019-11-01 11:26
 **/
public class StringDecoder1 extends ByteToMessageDecoder {

    private static final Logger logger = LoggerFactory.getLogger(StringDecoder1.class);

    final int length = 2048;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list) throws Exception {
        try {
            in.retain();
            byte[] headArray = new byte[3];
            in.readBytes(headArray);
            String head = new String(headArray);
            // 把读取的起始位置重置
            in.resetReaderIndex();


//            if (TcnConstant.CMD_HEADER.equals(head)) {
//                int strBeginIndex = in.readerIndex();
//                int readableBytes = in.readableBytes();
//
//                byte[] tailArray = new byte[3];
//                //数据末尾
//                in.getBytes(readableBytes - 3, tailArray);
//                String tail = new String(tailArray);
//                in.resetReaderIndex();
//                //没接收完
//                if (!TcnConstant.CMD_TAIL.equals(tail)) {
//                    logger.info("可读字节数readableBytes is {}", readableBytes);
//                    in.readerIndex(strBeginIndex);
//                    return;
//                }
//                ByteBufToBytes reader = new ByteBufToBytes();
//                String msg = new String(reader.read(in));
//                //in.retain(1);
//                list.add(msg);
//                d(in));
//                list.add(msg);
//            } else {
//                channelHandlerContext.fireChannelRead(in);
//            }
        } catch (Exception e) {
            logger.info("=================");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.err.println("--------数据读异常----------: ");
        cause.printStackTrace();
        ctx.close();
    }
}
