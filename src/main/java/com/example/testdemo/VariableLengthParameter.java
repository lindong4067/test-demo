
package com.example.testdemo;

import com.example.testbean.HelloWorld;

public class VariableLengthParameter {
    private VariableLengthParameter(){
        test();
        test("a","b");
        test(new String[]{"aaa","bbb"});
        test("ccc");
        test("111", 100, new HelloWorld());

    }

    private void test(){
        System.out.println("test");
    }

    private void test(String... strings){
        for(String str:strings){
            System.out.print(str + ", ");
        }
        System.out.println();
    }

    private void test(Object... objects){
        for (Object object : objects) {
            if (object instanceof String){
                System.out.println(object.toString());
            }else if(object instanceof Number){
                System.out.println(((Number) object).byteValue());
            }else {
                System.out.println(object.toString());
            }
        }
    }
    public static void main(String[] args) {
        new VariableLengthParameter();
    }
}
