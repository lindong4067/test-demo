/*
 *         File : ObjectEchoClientHandler.java
 *    Classname : ObjectEchoClientHandler
 *    Author(s) : eznlzhi
 *      Created : 2018-11-27
 *
 *
 */

package com.example.testframe.netty.getstart._7_objectecho;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.testframe.netty.getstart._7_objectecho.ObjectEchoClient.SIZE;

public class ObjectEchoClientHandler extends ChannelInboundHandlerAdapter {

    private final List<Integer> firstMessage;

    public ObjectEchoClientHandler() {
        firstMessage = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            firstMessage.add(i);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
