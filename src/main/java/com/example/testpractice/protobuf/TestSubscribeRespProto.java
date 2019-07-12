package com.example.testpractice.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class TestSubscribeRespProto {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeRespProto.SubscribeResp.Builder builder = SubscribeRespProto.SubscribeResp.newBuilder();
        builder.setSubReqID(1);
        builder.setDesc("This is response.");
        builder.setRespCode(200);
        SubscribeRespProto.SubscribeResp subscribeResp = builder.build();
        byte[] bytes = subscribeResp.toByteArray();
        System.out.println(subscribeResp);
        System.out.println("----------------Bytes");
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        System.out.println("----------------Bytes");
        SubscribeRespProto.SubscribeResp subscribeResp1 = SubscribeRespProto.SubscribeResp.parseFrom(bytes);
        System.out.println(subscribeResp1);

        System.out.println("subscribeResp equals subscribeResp1: " + subscribeResp.equals(subscribeResp1));
    }
}
