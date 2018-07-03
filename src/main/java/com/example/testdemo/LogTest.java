
package com.example.testdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class LogTest {

    @Test
    public void logtest(){
        String[] strings1 = {"a1", "b1", "c1"};
        String[] strings2 = {"a2", "b2", "c2"};
        String[] strings3 = {"a3", "b3", "c3"};
        String[][] stringss = {strings1, strings2, strings3};
        for (String[] strings : stringss) {
            log.info("log message : {}", Arrays.toString(strings));
        }

    }
}