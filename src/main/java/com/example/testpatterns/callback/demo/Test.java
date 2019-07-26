/*
 *         File : Test.java
 *    Classname : Test
 *    Author(s) : eznlzhi
 *      Created : 2018-07-17
 *
 *
 */

package com.example.testpatterns.callback.demo;

public class Test {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);
        client.sendMsg("Hello Server!");
    }

}
