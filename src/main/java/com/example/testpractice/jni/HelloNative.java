package com.example.testpractice.jni;

/**
 * C:\Users\EZNLZHI\IdeaProjects\test-demo\src\main\java 下, 执行:
 * javah -d ./jni -jni -classpath . com.example.testpractice.jni.HelloNative
 */
public class HelloNative {
    static {
        System.loadLibrary("HelloNative");
    }

    public static native void sayHello();

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        new HelloNative().sayHello();
    }
}
