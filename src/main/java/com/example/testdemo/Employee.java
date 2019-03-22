package com.example.testdemo;

public abstract class Employee {
    private String name;
    private String address;
    private int number;

    public Employee(String name, String address, int number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    /**
     * 声明抽象方法会造成以下两个结果：
     *
     *     如果一个类包含抽象方法，那么该类必须是抽象类。
     *     任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
     * @return
     */
    public abstract double computePay();
}
