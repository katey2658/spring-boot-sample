package com.busyzero.demo.netty.live;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {
    private static final String WEBSOCKET_PATH = "/websocket";

    private static Map<Integer, ChannelGroup> channelGroupMap = new ConcurrentHashMap<>();

    private static final String HTTP_REQUEST_STRING = "request";

    private WebSocketClientHandshaker handshaker;


    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        if (o instanceof FullHttpRequest) {

        } else if (o instanceof WebSocketFrame) {

        }

    }
}
