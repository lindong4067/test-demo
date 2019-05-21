package com.example.testpatterns.reactor.simpledemo;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Reactor reactor = new Reactor(8088);
        reactor.run();
    }
}
