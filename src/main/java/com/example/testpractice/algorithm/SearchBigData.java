package com.example.testpractice.algorithm;

import java.util.HashSet;
import java.util.Set;

public class SearchBigData {
    public static void main(String[] args) {
        long star = System.currentTimeMillis();

        Set<Integer> hashset = new HashSet<>(100) ;
        for (int i = 0; i < 100; i++) {
            hashset.add(i) ;
        }
        System.out.println("Set contains 1: " + hashset.contains(1));
        System.out.println("Set contains 2: " + hashset.contains(2));
        System.out.println("Set contains 3: " + hashset.contains(3));

        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }
}