package com.wy.protobuftest;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProtobufTest
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/2/16 19:44
 */

public class ProtobufTest {

    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqId(1);
        builder.setUserName("WY");
        builder.setProductName("Netty Book");
        builder.setAddress("shanghai");
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("编码前： " + req.toString());
        byte[] encode = encode(req);
        System.out.println("编码后： " + encode.toString());
        SubscribeReqProto.SubscribeReq decode = decode(encode);
        System.out.println("重新解码： " + decode.toString());
    }

}