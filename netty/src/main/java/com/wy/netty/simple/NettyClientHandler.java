package com.wy.netty.simple;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @ClassName NettyClientHandler
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/2/15 18:50
 */

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private int count = 1;



    //当通道就绪时，就会触发该方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("client " + ctx);
        for (int i = 0; i < 100; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer("hello ,server" + "$_", CharsetUtil.UTF_8));
        }
    }

    //当通道有读取事件时，会触发此方法
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String buf = (String) msg;
        System.out.println("服务器回复消息： " + buf + " 本次是第：" + count++ + "次");
//        System.out.println("服务器的地址： " + ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}