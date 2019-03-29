package com.example.testpatterns.adapter.demo;

public class ChineseSocket implements Socket {
    private Plug plug;

    public Plug getPlug() {
        return plug;
    }

    public void setPlug(Plug plug) {
        this.plug = plug;
    }

    @Override
    public void outPut() {
        System.out.println("Chinese style socket output");
        plug.input();
    }
}
