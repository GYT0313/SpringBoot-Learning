package com.gyt6;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket socket;
    private int flag;

    public ServerThread(Socket socket, int flag) {
        this.socket = socket;
        this.flag = flag;
    }


    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            BufferedWriter bw = new BufferedWriter(new FileWriter("Net\\copy.java"));
            System.out.println(Thread.currentThread().getName());
            File file = new File( "Net\\" + Thread.currentThread().getName() + "copy.java");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));


            BufferedWriter bwServer;
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            bwServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bwServer.write("文件上次陈工");
            bwServer.newLine();
            bwServer.flush();

            bw.close();
            bwServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
