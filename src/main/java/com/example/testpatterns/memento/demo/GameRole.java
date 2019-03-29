package com.example.testpatterns.memento.demo;

public class GameRole {
    private int physical;
    private int fighting;

    public void init() {
        this.physical = 100;
        this.fighting = 100;
    }

    public void show() {
        System.out.println("Physical: " + physical + ", Fighting:" + fighting);
    }

    public void combat() {
        this.fighting -= 50;
        this.physical -= 50;
    }

    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public int getFighting() {
        return fighting;
    }

    public void setFighting(int fighting) {
        this.fighting = fighting;
    }

    public RoleStateMemento createMemento() {
        return new RoleStateMemento(this);
    }

    public void restoreMemento(RoleStateMemento m) {
        this.physical = m.getPhysical();
        this.fighting = m.getFighting();
    }
}
