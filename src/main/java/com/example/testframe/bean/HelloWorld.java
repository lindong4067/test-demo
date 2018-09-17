package com.example.testframe.bean;

public class HelloWorld {

    private String say;

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public void init(){
        System.out.println("Person Init.");
    }

    public void destroy(){
        System.out.println("Person Destroy.");
    }

    @Override
    public String toString() {
        return "Person{" +
                "say='" + say + '\'' +
                '}';
    }
}
