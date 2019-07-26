/*
 *         File : TimeDecoder.java
 *    Classname : TimeDecoder
 *    Author(s) : eznlzhi
 *      Created : 2018-11-20
 *
 *
 */

package com.example.testframe.netty.getstart._2_echo;

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
//        out.add(in.readBytes(4));
        out.add(new UnixTime(in.readUnsignedInt()));
    }
}
