package com.example.testdemo;

class Parent2 {
    //父类静态代码块一
    static {
        System.out.println("父类静态代码块一，只会执行一次");
    }

    //父类静态成员变量
    private static int age = getAge();
    //父类普通成员变量
    private String car = getCar();

    //父类构造方法
    public Parent2() {
        System.out.println("父类构造方法");
    }

    //父类构造代码块一
    {
        System.out.println("父类构造代码块一");
    }

    public String getCar() {
        System.out.println("父类普通成员变量初始化");
        return "Benz";
    }

    //父类构造代码块二
    {
        System.out.println("父类构造代码块二");
    }

    public static int getAge() {
        System.out.println("父类静态成员变量初始化");
        return 30;
    }

    //父类静态代码块二
    static {
        System.out.println("父类静态代码块二，只会执行一次");
    }
}

class Son extends Parent2 {
    //子类静态成员变量
    private static String name = getName();

    //子类构造方法
    public Son() {
        System.out.println("子类构造方法");
    }


    //子类静态代码块
    static {
        System.out.println("子类静态代码块，只会执行一次");
    }

    //子类普通成员变量
    private double height = getHeight();

    public static String getName() {
        System.out.println("子类静态成员变量初始化");
        return "Son";
    }

    public double getHeight() {
        System.out.println("子类普通成员变量初始化");
        return 1.65;
    }

    //子类构造代码块
    {
        System.out.println("子类构造代码块");
    }
}

public class LoaderOrderTest {
    public static void main(String[] args) {
        {
            System.out.println("主方法中的普通代码块一");
        }
        System.out.println("创建第一个子类对象----------------------------");
        Son son1 = new Son();
        System.out.println("创建第二个子类对象----------------------------");
        Son son2 = new Son();
        {
            System.out.println("主方法中的普通代码块二");
        }
    }
}
