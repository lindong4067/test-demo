package com.example.testpractice.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetingServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        while (true) {
            System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
            //输入流，接收数据
            InputStream serverInputStream = server.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(serverInputStream);
            System.out.println(dataInputStream.readUTF());
            //输出流，发送数据
            OutputStream outputStream = server.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("谢谢你连接我: " + server.getLocalSocketAddress() + " 再见!");
            server.close();
        }
    }
}
