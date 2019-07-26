/*
 *         File : TimeEncoder.java
 *    Classname : TimeEncoder
 *    Author(s) : eznlzhi
 *      Created : 2018-11-20
 *
 *
 */

package com.example.testframe.netty.getstart._2_echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

public class TimeEncoder extends ChannelHandlerAdapter {
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        UnixTime m = (UnixTime) msg;
        ByteBuf encoded = ctx.alloc().buffer(4);
        encoded.writeInt((int)m.getValue());
        ctx.write(encoded, promise);
    }
}
