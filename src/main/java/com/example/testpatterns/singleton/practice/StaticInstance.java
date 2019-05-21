package com.example.testpatterns.singleton.practice;

public class StaticInstance {
    /**
     * 私有构造方法，使外部无法通过构造方法的形式构造类实例，实现全局唯一的目的
     */
    private StaticInstance() {
    }

    /**
     * 类级内部类，用于缓存类实例 该类将在被调用时才会被装载，
     * 从而实现了延迟加载同时由于instance采用静态初始化的方式，
     * 因此JVM能保证其线程安全性
     */
    private static class Instance {
        private static StaticInstance instance = new StaticInstance();
    }

    /**
     * 类实例的全局访问方法 添加static关键词使得外部可以通过类名直接调用该方法获取类实例
     * @return
     */
    public static StaticInstance getInstance() {
        return Instance.instance;
    }

}
