
package com.example.testdemo;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {
    @Test
    public void stringBuilderTest2() {
        String t1 = "Person";
        String substring = t1.substring(0, t1.length() - 1);
        System.out.println(t1);
        System.out.println(substring);
        StringBuilder builder = new StringBuilder();
        builder.append("Person");
        String substring1 = builder.substring(0, builder.length() - 1);
        System.out.println(builder.toString());
        System.out.println(substring1);


    }

    @Test
    public void test02(){
        //
        Integer integer = null;
        String value = String.valueOf(integer);
        Assert.assertEquals(value, "null");
    }
}
