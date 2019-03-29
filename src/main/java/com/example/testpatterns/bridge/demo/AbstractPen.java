package com.example.testpatterns.bridge.demo;

public abstract class AbstractPen implements Pen {
    private Refill refill;

    @Override
    public void write() {
        texture();
        refill.color();
    }

    @Override
    public void put(Refill refill) {
        this.refill = refill;
    }
}
