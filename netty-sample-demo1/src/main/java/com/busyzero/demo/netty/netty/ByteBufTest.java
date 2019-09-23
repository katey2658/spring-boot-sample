package com.busyzero.demo.netty.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBufTest {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer();
        byteBuf.discardReadBytes();

    }
}
