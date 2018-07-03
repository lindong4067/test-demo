
package com.example.testdemo;

import com.example.testbean.HelloWorld;

import java.lang.reflect.Field;

public class ReflectTest {

    public static void getProperty(Object owner, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Class<?> ownerClass = owner.getClass();
//        Field field = ownerClass.getField(fieldName);
        Field[] fields = ownerClass.getFields();
        for (Field field1 : fields) {
            field1.setAccessible(true);
            System.out.println(field1.getName());
        }
//        Object property = field.get(owner);
//        return property;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setSay("Hello World!");
        getProperty(helloWorld, "Say");
//        System.out.println(property);
    }
}
