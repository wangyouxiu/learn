package com.wy.netty.messagepack;

import com.wy.netty.pojo.User;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @ClassName NettyServerHandler
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/2/15 18:19
 */

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    private int count = 1;
    private User user = new User("李四", 20);

    //读取数据
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端发送消息是： " + msg + " 本次是第：" + count++ + "次");
        ctx.writeAndFlush(user);
    }


    //处理异常，一般需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}