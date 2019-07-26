/*
 *         File : TestNIO.java
 *    Classname : TestNIO
 *    Author(s) : eznlzhi
 *      Created : 2018-09-07
 *
 *
 */

package com.example.testframe.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;

public class TestNIO {

    @Test
    public void testByteBuf(){
        ByteBuf b = Unpooled.buffer(4);
        System.out.println(b.writerIndex());
        System.out.println(b.readerIndex());
        System.out.println("--------");
        b.writeByte('1');
        b.writeByte('2');
        b.writeByte('3');
        b.writeByte('4');
        //Auto expansion
        b.writeByte('5');
        b.readByte();
        b.readByte();
        b.readByte();
        System.out.println(b.writerIndex());
        System.out.println(b.readerIndex());
        System.out.println("--------");
        ByteBuf buf = Unpooled.buffer(16);
        int capacity = buf.capacity();
        for (int i = 0; i < capacity; i++) {
            buf.writeByte(i + 1);
        }

        for (int i = 0; i < capacity; i++) {
//            System.out.print(buf.getByte(i) + "    ");
            System.out.print(buf.readByte() + "    ");
        }

        System.out.println("\n--------");
        System.out.println(buf.writerIndex());
        System.out.println(buf.readerIndex());
    }

    @Test
    public void testByteBuffer(){
        ByteBuffer b = ByteBuffer.allocate(128);
        try(FileChannel fin = new FileInputStream("C:\\Temp\\out\\filein.txt").getChannel();
            FileChannel fout = new FileOutputStream("C:\\Temp\\out\\fileout.txt").getChannel()){
            while (fin.read(b) != -1){
                b.flip();
                fout.write(b);
                b.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCompositeBuffer(){

        CompositeByteBuf compBuf = Unpooled.compositeBuffer();

        ByteBuf heapBuf = Unpooled.buffer(8);

        ByteBuf directBuf = Unpooled.directBuffer(16);

        compBuf.addComponents(heapBuf, directBuf);

        compBuf.removeComponent(0);

        Iterator<ByteBuf> iter = compBuf.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next().toString());
        }

        if (!compBuf.hasArray()){
            int len = compBuf.readableBytes();
            byte[] arr = new byte[len];

            compBuf.getBytes(0, arr);

            for (byte b : arr) {
                System.out.println(b);
            }
        }
    }
}
