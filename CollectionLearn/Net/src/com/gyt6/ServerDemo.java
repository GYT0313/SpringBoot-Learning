package com.gyt6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        int count = 0;

        while (true) {
            // 监听客户端连接
            Socket socket = serverSocket.accept();
            new Thread(new ServerThread(socket, count++)).start();
        }

    }
}
