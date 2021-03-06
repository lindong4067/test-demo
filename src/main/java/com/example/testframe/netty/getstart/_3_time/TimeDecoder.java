/*
 *         File : TimeDecoder.java
 *    Classname : TimeDecoder
 *    Author(s) : eznlzhi
 *      Created : 2018-11-21
 *
 *
 */

package com.example.testframe.netty.getstart._3_time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class TimeDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4){
            return;
        }
        out.add(new UnixTime(in.readUnsignedInt()));
    }
}
