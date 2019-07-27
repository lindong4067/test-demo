package com.example.testdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
public class TestDemoApplication {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String className = null, methodName = null;
        if (args.length == 0) {
            System.out.println("Please input class name and method name! ");
        }
        if (args.length > 0 && args[0].equals("-h")) {
            System.out.println("Please input class name and method name! ");
        }
        if (args.length > 0) {
            className = args[0];
            System.out.println("Class name: " + args[0]);
        }
        if (args.length > 1){
            methodName = args[1];
            System.out.println("Method name: " + args[1]);
        }
        if (args.length == 1){
            methodName = "main";
            System.out.println("Method name: main");
        }
        if (className == null || methodName == null) {
            return;
        }
        Class<?> aClass = Class.forName(className);
        Object obj = aClass.newInstance();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Object[] arg = new Object[]{""};
                method.setAccessible(true);
                method.invoke(null, (Object)new String[]{"xxx"});
            }
        }
//        SpringApplication.run(TestDemoApplication.class, args);
    }
}
