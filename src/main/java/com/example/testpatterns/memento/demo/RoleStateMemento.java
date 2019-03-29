package com.example.testpatterns.memento.demo;

class RoleStateMemento {
    private int physical;
    private int fighting;

    RoleStateMemento(GameRole role) {
        this.physical = role.getPhysical();
        this.fighting = role.getFighting();
    }

    int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    int getFighting() {
        return fighting;
    }

    public void setFighting(int fighting) {
        this.fighting = fighting;
    }
}
