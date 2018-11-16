package com.example.testpractice.config;

public class Cfg {

    public Service service;

    public static class Service{
        public final boolean debug;
        public final double factor;
        public final int poolSize;
        public final String url;

        public Service(boolean debug, double factor, int poolSize, String url) {
            this.debug = debug;
            this.factor = factor;
            this.poolSize = poolSize;
            this.url = url;
        }
    }
}
