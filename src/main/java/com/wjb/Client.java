package com.wjb;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
//        C:\Users\wei72\Desktop\psc.jpg
        File file = new File("C:\\Users\\wei72\\Desktop\\123.jpg");
        byte[] imageData = readImg(file.getAbsolutePath());
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(imageData);
        outputStream.close();
        System.out.println("客户端接受结束");
        socket.close();
    }

    public static byte[] readImg(String url) throws Exception {
        FileInputStream fis = new FileInputStream(url);
        // 2. 读取图片数据
        byte[] imageData = new byte[fis.available()];
        fis.read(imageData);
        return imageData;
    }
}