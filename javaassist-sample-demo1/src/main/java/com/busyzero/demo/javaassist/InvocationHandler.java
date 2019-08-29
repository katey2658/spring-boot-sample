package com.busyzero.demo.javaassist;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocationHandler {

    private Invoker invoker;

    public InvocationHandler(Invoker invoker) {
        this.invoker = invoker;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
//        if (method.getName().equals("sayHello")) {
//            return "sayHello";
//        }
//        if (method.getName().equals("sayBye")) {
//            return "sayBye";
//        }

        if (method.getName().equals("equals") || method.getName().equals("hasCode")) {
            try {
                method.invoke(proxy, args);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


        String methodName = method.getName();
        Invocation invocation = new Invocation();
        invocation.setMethodName(methodName);
        invocation.setParameterTypes(new Class[]{String.class});
        invocation.setArguments(args);
        invocation.setServiceName(invoker.getInterface().getName());

        EventLoopGroup group = new NioEventLoopGroup();
        try {

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ObjectDecoder(1024, ClassResolvers.cacheDisabled(this.getClass().getClassLoader())));
                    ch.pipeline().addLast(new ObjectEncoder());
                    ch.pipeline().addLast(new ConsumerHandler(invocation));
                }
            });
            //从注册中心获取服务端ip和端口
            ChannelFuture f = bootstrap.connect("127.0.0.1", 8888).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
        return ((Result)ConsumerHandler.res).getData();
    }
}
