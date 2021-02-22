package com.wy.netty.simple;

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

    //读取数据
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("服务器读取线程： " + Thread.currentThread().getName());
//        System.out.println("server ctx = " + ctx);
//        Channel channel = ctx.channel();
//        ChannelPipeline pipeline = ctx.pipeline();
        String buf = (String) msg;
        System.out.println("客户端发送消息是： " + buf + " 本次是第：" + count++ + "次");
//        System.out.println("客户端地址: " + channel.remoteAddress());
        ctx.writeAndFlush(Unpooled.copiedBuffer(buf + "$_", CharsetUtil.UTF_8));
    }


    //处理异常，一般需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}