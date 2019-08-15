package com.gyt2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.56.1", 1234);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());

        byte[] bytes = new byte[1024];
        int len = socket.getInputStream().read(bytes);
        String data = new String(bytes, 0, len);
        System.out.println("反馈数据: " + data);

        socket.close();
    }
}
