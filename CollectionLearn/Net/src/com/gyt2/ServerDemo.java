package com.gyt2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);

        Socket socket = serverSocket.accept();

        byte[] bytes = new byte[1024];
        int len = socket.getInputStream().read(bytes);
        String data = new String(bytes, 0, len);

        System.out.println(data);

        socket.getOutputStream().write("数据已收到".getBytes());

        serverSocket.close();
    }
}
