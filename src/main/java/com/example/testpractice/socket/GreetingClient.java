package com.example.testpractice.socket;

import java.io.*;
import java.net.*;

public class GreetingClient {
    public static void main(String[] args) throws IOException {
        String hostname = args[0];
        Integer port = Integer.valueOf(args[1]);
        System.out.printf("连接到 HostName: %s, Port: %s\n", hostname, port);
        Socket client = new Socket(hostname, port);
        System.out.printf("远程主机地址: %s\n", client.getRemoteSocketAddress());
        //输出流，发给服务端
        OutputStream outputStream = client.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("Hello, I'm " + client.getLocalSocketAddress());
        //输入流，接收服务端
        InputStream inputStream = client.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String message = dataInputStream.readUTF();
        System.out.printf("服务端响应: %s\n", message);
        client.close();
    }
}
