package com.example.testpatterns.promise.jpromise.concurrent;

public interface AsyncTask<V>{
    V call() throws Exception;
}