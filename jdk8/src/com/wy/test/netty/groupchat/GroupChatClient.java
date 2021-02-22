package com.wy.test.netty.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @ClassName GroupChatClient
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/2/15 15:16
 */

public class GroupChatClient {

    private Selector selector = null;

    private SocketChannel socketChannel = null;

    private static final String IP = "127.0.0.1";
    private static final int PORT = 6666;
    private String username = null;

    public GroupChatClient() {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress(IP,PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(username + " is ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            while (true) {
                if (selector.select() > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isReadable()) {
                            SocketChannel socket = (SocketChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            socket.read(buffer);
                            System.out.println(new String(buffer.array()));
                        }
                        iterator.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String str) {
        try {
            str = username + "说:" + str;
            socketChannel.write(ByteBuffer.wrap(str.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        GroupChatClient groupChatClient = new GroupChatClient();
        new Thread() {
            @Override
            public void run() {
                groupChatClient.read();
            }
        }.start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            groupChatClient.write(s);
        }
    }


}