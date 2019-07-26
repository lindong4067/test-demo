/*
 *         File : PromiseExample.java
 *    Classname : PromiseExample
 *    Author(s) : eznlzhi
 *      Created : 2018-10-18
 *
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
