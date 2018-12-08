package com.example.testframe.netty.getstart._8_http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.ssl.SslContext;

public class HttpSnoopClientInitializer extends ChannelInitializer<SocketChannel> {
    private final SslContext sslCtx;

    public HttpSnoopClientInitializer(SslContext sslCtx) {
        this.sslCtx = sslCtx;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        if (sslCtx != null){
            pipeline.addLast(sslCtx.newHandler(ch.alloc()));
        }
        pipeline.addLast(new HttpClientCodec());
        pipeline.addLast(new HttpContentDecompressor());
        pipeline.addLast(new HttpSnoopClientHandler());
    }
}
