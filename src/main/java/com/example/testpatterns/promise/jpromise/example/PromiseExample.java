/*
 *         File : PromiseExample.java
 *    Classname : PromiseExample
 *    Author(s) : eznlzhi
 *      Created : 2018-10-18
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

package com.example.testpatterns.promise.jpromise.example;

import com.example.testpatterns.promise.jpromise.concurrent.AsyncTask;
import com.example.testpatterns.promise.jpromise.core.Promise;

import java.util.concurrent.TimeUnit;

public class PromiseExample {

    public static void main (String ...s) {
        long start = System.nanoTime();
        //提交任务不需要立即拿到结果
        Promise<String> resolve1 = Promise.wrap(new AsyncTask<String>() {
            @Override
            public String call() throws Exception {
                return getRelatedRoles();
            }

            private String getRelatedRoles() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                }
                return "Related Roles...";
            }
        });
        //提交任务不需要立即拿到结果
        Promise<String> resolve2 = Promise.wrap(new AsyncTask<String>() {
            @Override
            public String call() throws Exception {
                return getRelatedNews();
            }

            private String getRelatedNews() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
                return "Related News...";
            }
        });

        System.out.println("Result:" + resolve1.get() + resolve2.get());
        System.out.println("take:" + TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - start)) + "ms");
    }
}
