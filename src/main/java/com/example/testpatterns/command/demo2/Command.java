package com.example.testpatterns.command.demo2;

public abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver){
        this.receiver = receiver;
    }

    public abstract void executeCommand();
}
