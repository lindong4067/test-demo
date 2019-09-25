package com.example.testeffective.myrpc.provider;

public interface Registry {
    void register(Class clazz, RegistryInfo registryInfo) throws Exception;
}
