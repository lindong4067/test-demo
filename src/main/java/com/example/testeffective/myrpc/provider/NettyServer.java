package com.example.testeffective.myrpc.provider;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.util.List;
import java.util.Map;

public class NettyServer {
    // 负责调用方法的Handler
    private RpcInvokeHandler rpcInvokeHandler;

    public NettyServer(List serverConfigs, Map interfaceMethods) {
        this.rpcInvokeHandler = new RpcInvokeHandler(serverConfigs, interfaceMethods);
    }


    public void init(Integer port) throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ByteBuf delimiter = Unpooled.copiedBuffer("&&".getBytes());
                        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024 * 1024, delimiter));
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(rpcInvokeHandler);
                    }
                });
        bootstrap.bind(port).sync();
        System.out.println("Start Netty Server, Port : " + port);
    }
}
