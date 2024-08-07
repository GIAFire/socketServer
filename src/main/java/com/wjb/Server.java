package com.wjb;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器启动");
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("socket地址:"+socket);
            InputStream inputStream = socket.getInputStream();
            int read = inputStream.read();
            System.out.println("read:"+read);
            inputStream.close();
            socket.close();
            System.out.println("socket地址222:"+socket);
        }

    }
}