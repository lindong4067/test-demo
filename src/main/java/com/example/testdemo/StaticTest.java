
package com.example.testdemo;

public class StaticTest {
    /**
     * 静态代码块
     */
    static{
        System.out.println("执行静态代码块...");
    }

    /**
     * 构造代码块
     */
    {
        System.out.println("执行构造代码块...");
    }

    /**
     * 无参构造函数
     */
    public StaticTest(){
        System.out.println("执行无参构造函数...");
    }

    /**
     * 有参构造函数
     * @param id
     */
    public StaticTest(String id){
        System.out.println("执行有参构造函数...");
    }

    public static void main(String[] args) {
        System.out.println("----------------------");
        new StaticTest();
        System.out.println("----------------------");
        new StaticTest("1");
    }
}