package com.example.testdemo;

public class ClassInitializationDemo {
    //Init 1
    private static String staticProperty = getStaticProperty();

    private static String getStaticProperty() {
        System.out.println("Static Property");
        return "Static Property";
    }

    //Init 2
    static {
        System.out.println("Static method block");
    }
    //Init 3
    private String normalProperty = getNormalProperty();

    private String getNormalProperty() {
        System.out.println("Normal Property");
        return "Normal Property";
    }
    //Init 4
    {
        System.out.println("Normal method block");
    }
    //Init 5
    public ClassInitializationDemo() {
        System.out.println("Constructor method block");
    }

    public String getString(){
        return "Normal Mothod";
    }

    public static void main(String[] args) {
        new ClassInitializationDemo();
    }
}
