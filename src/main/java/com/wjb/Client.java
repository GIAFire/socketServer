package com.wjb;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        File file = new File("C:\\Users\\L\\Desktop\\123.jpg");
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[1024];
        int len;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = fis.read(b)) != -1){
            bos.write(b, 0, len);
        }
        byte[] imageData = bos.toByteArray();
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