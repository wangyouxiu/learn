package com.wy.messagepack;


import org.msgpack.MessagePack;
import org.msgpack.template.Templates;
import org.msgpack.type.Value;
import org.msgpack.unpacker.Converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MessagePackMode1
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/2/16 16:41
 */

public class MessagePackMode1 {
    public static void main(String[] args) throws IOException {
        List<String> src = new ArrayList<>();
        src.add("msgpack");
        src.add("kunofs");
        src.add("viver");

        MessagePack messagePack = new MessagePack();
        //序列化
        byte[] raw = messagePack.write(src);

        //使用模板进行反序列化
        List<String> dst1 = messagePack.read(raw, Templates.tList(Templates.TString));
        System.out.println(dst1.get(0));
        System.out.println(dst1.get(1));
        System.out.println(dst1.get(2));

        //反序列化为值，然后进行类型转换
        Value dynamic = messagePack.read(raw);
        List<String> dst2 = new Converter(dynamic).read(Templates.tList(Templates.TString));
        System.out.println(dst2.get(0));
        System.out.println(dst2.get(1));
        System.out.println(dst2.get(2));
    }

}