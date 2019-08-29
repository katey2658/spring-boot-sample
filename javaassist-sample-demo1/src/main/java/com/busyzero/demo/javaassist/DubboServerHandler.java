package com.busyzero.demo.javaassist;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Map;

public class DubboServerHandler extends ChannelInboundHandlerAdapter {
    private final Map<String, Invoker<?>> invokerMap;

    public DubboServerHandler(Map<String, Invoker<?>> invokerMap) {
        this.invokerMap = invokerMap;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务端收到消息：" + msg);
        Invocation req = (Invocation) msg;
        String serviceName = req.getServiceName();
        Invoker<?> invoker = invokerMap.get(serviceName);
        Result result = invoker.invoke(req);
        ctx.writeAndFlush(result);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
