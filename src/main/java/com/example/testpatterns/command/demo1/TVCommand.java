/*
 *         File : TVCommand.java
 *    Classname : TVCommand
 *    Author(s) : eznlzhi
 *      Created : 2018-07-19
 *
 *
 */

package com.example.testpatterns.command.demo1;

public class TVCommand implements Command {

    private TV tv;

    public TVCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
