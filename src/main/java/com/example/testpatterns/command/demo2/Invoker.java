package com.example.testpatterns.command.demo2;

public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.executeCommand();
    }
}
