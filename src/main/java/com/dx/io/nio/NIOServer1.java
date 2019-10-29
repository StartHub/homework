package com.dx.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author : dengxu
 * @create 2019-10-28 16:08
 **/
public class NIOServer1 {

    public Selector selector;

    public ServerSocketChannel serverSocketChannel;

    public void initServer(int port) throws Exception{

        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost", port));

        this.selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws Exception{

        System.out.println("Server Started Successed!");
        while (true){
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    SocketChannel channel = serverSocketChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    recvAndReply(key);
                }

                iterator.remove();
            }
        }
    }

    private void recvAndReply(SelectionKey key) throws Exception {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        int i = channel.read(buffer);
        if(i != -1){
            String msg = new String(buffer.array()).trim();
            System.out.println("NIO server received message = " + msg);
            System.out.println("NIO server reply = " + msg);
            channel.write(buffer.wrap(msg.getBytes()));
        } else {
            channel.close();
        }
    }

    public static void main(String[] args) throws Exception{

        NIOServer1 server1 = new NIOServer1();
        server1.initServer(9090);
        server1.listen();
    }
}
