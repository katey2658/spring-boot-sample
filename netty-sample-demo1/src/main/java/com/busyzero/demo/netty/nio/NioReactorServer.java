package com.busyzero.demo.netty.nio;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NioReactorServer {
    public static void main(String[] args) throws IOException {
        Selector selector = initServer();

        while (selector.select() > 0) {
            Set<SelectionKey> set = selector.selectedKeys();
            Iterator<SelectionKey> iterator = set.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                dispatcher(selector, selectionKey);
                iterator.remove();
            }
        }
    }

    private static void dispatcher(Selector selector, SelectionKey selectionKey) throws IOException {
        try {
            if (selectionKey.isAcceptable()) {
                acceptHandler(selector, selectionKey);
            } else if (selectionKey.isReadable()) {
                readHandler(selector, selectionKey);
            }
        } catch (IOException | InterruptedException e) {
            selectionKey.cancel();
            selectionKey.channel().close();
        }
    }

    private static void readHandler(Selector selector, SelectionKey selectionKey) throws IOException, InterruptedException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
        buffer.clear();
        StringBuilder sb = new StringBuilder();
        int read = 0;
        while ((read = channel.read(buffer)) > 0) {
            buffer.flip();
            sb.append(Charset.forName("UTF-8").newDecoder().decode(buffer));
            buffer.clear();
        }
        System.out.printf("收到 %s 发来的：%s\n", channel.getRemoteAddress(), sb);
        buffer.clear();
// 模拟server端处理耗时
        Thread.sleep((int) (Math.random() * 1000));
        buffer.put(("收到，你发来的是：" + sb + "\r\n").getBytes("utf-8"));
        buffer.flip();
        channel.write(buffer);
        System.out.printf("回复 %s 内容是： %s\n", channel.getRemoteAddress(), sb);
        channel.register(selector, SelectionKey.OP_READ, buffer.clear());
    }

    private static void acceptHandler(Selector selector, SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel channel = serverSocketChannel.accept();
        channel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        channel.register(selector, SelectionKey.OP_READ, byteBuffer);
    }

    private static Selector initServer() throws IOException{
        ServerSocketChannel  serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8888));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        return selector;
    }
}
