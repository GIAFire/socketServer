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
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            byte[] bytes = new byte[1024];
            int readLen = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((readLen = bis.read(bytes)) != -1){
                bos.write(bytes,0,readLen);
            }
            byte[] imageData = bos.toByteArray();
            String img = "src\\123.jpg";
            FileOutputStream outputStream = new FileOutputStream(img);
            outputStream.write(imageData);
            outputStream.close();
            bis.close();
            bos.close();
            socket.close();
        }

    }
}