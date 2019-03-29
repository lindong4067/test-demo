package com.example.testpatterns.adapter.demo;

public class Client {
    public static void main(String[] args) {
        Socket chineseSocket = new ChineseSocket();
        chineseSocket.setPlug(new PlugAdapter(new AmericanPlug()));
        chineseSocket.outPut();

        chineseSocket.setPlug(new PlugAdapter(new EnglishPlug()));
        chineseSocket.outPut();

        chineseSocket.setPlug(new ChinesePlug());
        chineseSocket.outPut();
        /*
        * 这个Demo可以改进的地方：
        * 1.AmericanPlug和EnglishPlug不应该可以直接使用
        * 2.可以自动决定要不要使用Adapter
        */
    }
}
