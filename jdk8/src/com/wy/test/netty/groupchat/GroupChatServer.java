package com.wy.test.netty.groupchat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName GroupChatServer
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/2/15 14:52
 */

public class GroupChatServer {

    private Selector selector = null;
    private ServerSocketChannel serverSocketChannel = null;
    private static final int PORT = 6666;

    public GroupChatServer() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {
            while (true) {
                if (selector.select(2000) == 0) {
                    continue;
                }
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        SocketChannel socket = serverSocketChannel.accept();
                        socket.configureBlocking(false);
                        socket.register(selector, SelectionKey.OP_READ);
                        System.out.println(socket.getRemoteAddress() + "上线了");
                    }
                    if (key.isReadable()) {
                        readInfo(key);
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readInfo(SelectionKey key) {
        SocketChannel socket = null;
        try {
            socket = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socket.read(buffer);
            String str = new String(buffer.array());
            System.out.println(str);
            write(str, socket);
        } catch (IOException e) {
            try {
                System.out.println(socket.getRemoteAddress().toString().substring(1) + "下线了");
                key.cancel();
                socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }


    public void write(String str,SocketChannel self) {
        try {
            Set<SelectionKey> selectionKeys = selector.keys();
            for (SelectionKey key : selectionKeys) {
                SelectableChannel channel = key.channel();
                if (channel instanceof SocketChannel && channel != self) {
                    SocketChannel socket = (SocketChannel) channel;
                    socket.write(ByteBuffer.wrap(str.getBytes()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }

}