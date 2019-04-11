package com.example.testpractice.classloader;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("当前类的ClassLoader： " + classLoader);
        System.out.println("当前类的父ClassLoader： " + classLoader.getParent());
        System.out.println("当前类的父父ClassLoader： " + classLoader.getParent().getParent());

        try {
            Class<?> aClass = Class.forName("com.example.testpractice.classloader.ClassLoaderTest", true, classLoader.getParent());

        } catch (ClassNotFoundException e) {
            System.out.println("类加载失败01");
            e.printStackTrace();
        }
    }
}
