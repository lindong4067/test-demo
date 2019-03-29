package com.example.testpatterns.adapter.demo;

public class PlugAdapter implements Adapter {

    private Plug plug;

    public PlugAdapter(Plug plug) {
        this.plug = plug;
    }

    @Override
    public void input() {
        convert();
        plug.input();
    }

    @Override
    public void convert() {
        System.out.println("Adapter change style.");
    }
}
