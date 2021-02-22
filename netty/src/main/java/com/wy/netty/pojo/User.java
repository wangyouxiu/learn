package com.wy.netty.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.msgpack.annotation.Message;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/2/16 17:19
 */
@Message
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String userName;
    private int age;
}