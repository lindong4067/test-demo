package com.example.testpatterns.memento.demo;

public class Client {

    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        RoleStateManage stateManage = new RoleStateManage();

        gameRole.init();
        stateManage.saveMemento(gameRole.createMemento());

        gameRole.show();
        gameRole.combat();
        gameRole.show();
        gameRole.combat();
        gameRole.show();
        gameRole.combat();
        gameRole.show();

        gameRole.restoreMemento(stateManage.getMemento());
        gameRole.show();
    }
}
