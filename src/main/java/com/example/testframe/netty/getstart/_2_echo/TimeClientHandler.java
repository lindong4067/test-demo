/*
 *         File : TimeClientHandler.java
 *    Classname : TimeClientHandler
 *    Author(s) : eznlzhi
 *      Created : 2018-11-20
 *
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.
 * The Copyright to the computer program(s) herein is the property of
 * Ericsson AB, Sweden.
 * The program(s) may be used and/or copied with the written permission
 * from Ericsson AB or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s)
 * have been supplied.
 *
 */

package com.example.testframe.netty.getstart._2_echo;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;


public class TimeClientHandler extends ChannelHandlerAdapter {
//    private ByteBuf buf;
//    @Override
//    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        buf = ctx.alloc().buffer(4);
//    }
//
//    @Override
//    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//        buf.release();
//        buf = null;
//    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ADVANCE SOLUTION
        UnixTime m = (UnixTime) msg;
        System.out.println(m);
        ctx.close();

//        SIMPLE SOLUTION
//        ByteBuf m = (ByteBuf) msg;
//        buf.writeBytes(m);
//        m.release();
//        if (buf.readableBytes() >= 4){
//            long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
//            System.out.println(new Date(currentTimeMillis));
//            ctx.close();
//        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
