package com.example.testpatterns.flyweight.demo;

public abstract class Flyweight {
    //内部状态
    public String inside;
    //外部状态
    public final String outside;

    protected Flyweight(String outside) {
        this.outside = outside;
    }

    public abstract void operate(int i);

    public String getInside() {
        return inside;
    }

    public void setInside(String inside) {
        this.inside = inside;
    }
}
