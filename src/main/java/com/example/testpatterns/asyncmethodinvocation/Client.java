/*
 *         File : Client.java
 *    Classname : Client
 *    Author(s) : eznlzhi
 *      Created : 2018-07-11
 *
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.
 * The Copyright to the computer program(s) herein is the property of
 * Ericsson AB, Sweden.
 * The program(s) may be used and/or copied with the written permission
 * from Ericsson AB or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s)
 * have been supplied.
 *
 */

package com.example.testpatterns.asyncmethodinvocation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Client {

    private static <T> Callable<T> lazyval(T value, long delayMillis) {
        return () -> {
            Thread.sleep(delayMillis);
            return value;
        };
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadAsyncExecutor executor = new ThreadAsyncExecutor();
        AsyncResult<String> result1 = executor.startProcess(lazyval("Hello World!", 3000));
        System.out.println("Result1 : " + executor.endProcess(result1));
        AsyncResult<String> result2 = executor.startProcess(lazyval("Hello World!", 2000));
        System.out.println("Result2 : " + executor.endProcess(result2));
        AsyncResult<String> result3 = executor.startProcess(lazyval("Hello World!", 1000));
        System.out.println("Result3 : " + executor.endProcess(result3));
        AsyncResult<String> result4 = executor.startProcess(lazyval("Hello World!", 500));
        System.out.println("Result4 : " + executor.endProcess(result4));
        AsyncResult<String> result5 = executor.startProcess(lazyval("Hello World!", 500));
        System.out.println("Result5 : " + executor.endProcess(result5));
    }
}
