package com.example.testdemo;

public class Other {
    public static void main(String[] args) {
        Parent parent = new Parent();
        String param2 = parent.param2;
        //没有继承关系的同包类也能访问 protected 属性
    }
}
