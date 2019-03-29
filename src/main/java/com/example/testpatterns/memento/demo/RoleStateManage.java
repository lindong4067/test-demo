package com.example.testpatterns.memento.demo;

import java.util.ArrayDeque;
import java.util.Deque;

public class RoleStateManage {
    private Deque<RoleStateMemento> roleStateMementoStack = new ArrayDeque<>();

    public RoleStateMemento getMemento() {
        if (!roleStateMementoStack.isEmpty()) {
            System.out.println("Rollback state.");
            return roleStateMementoStack.pop();
        }
        return null;
    }

    public void saveMemento(RoleStateMemento state) {
        System.out.println("Save state.");
        roleStateMementoStack.push(state);
    }
}
