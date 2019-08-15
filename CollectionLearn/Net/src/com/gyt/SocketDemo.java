package com.gyt;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket(InetAddress.getByName("192.168.56.1"), 10000);
        Socket socket = new Socket("192.168.56.1", 10000);

        OutputStream outputStream =socket.getOutputStream();
        outputStream.write("hello, coming".getBytes());

        socket.close();
    }
}
