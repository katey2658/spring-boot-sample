package com.busyzero.demo.javaassist;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ConsumerHandler extends ChannelInboundHandlerAdapter {
    public static  Object res;
    private Invocation invocation;

    public ConsumerHandler(Invocation invocation) {
        this.invocation = invocation;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(invocation);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("---------" + msg);
        res = msg;
        ctx.flush();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
