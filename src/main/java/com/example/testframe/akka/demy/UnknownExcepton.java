package com.example.testframe.akka.demy;

public class UnknownExcepton extends Exception {
    private final Object object;
    public UnknownExcepton(Object p0) {
        super();
        this.object = p0;
    }
}
