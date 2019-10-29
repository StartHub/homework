package com.dx.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author : dengxu
 * @create 2019-10-28 16:53
 **/
public class NIOClient1 {

    private SocketChannel channel;

    public void initClient(String host, int port) throws Exception{

        InetSocketAddress address = new InetSocketAddress(host, port);
        this.channel = SocketChannel.open(address);
    }

    public void sendAndRecv(String words) throws Exception {
        byte[] msg = new String(words).getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(msg);
        System.out.println("Client sending: " + words);
        channel.write(buffer);
        buffer.clear();
        channel.read(buffer);
        System.out.println("Client received: " + new String(buffer.array()).trim());
        channel.close();
    }

    public static void main(String[] args) throws Exception {
        NIOClient1 client = new NIOClient1();
        client.initClient("localhost", 9090);
        client.sendAndRecv("I am a client");
    }
}
