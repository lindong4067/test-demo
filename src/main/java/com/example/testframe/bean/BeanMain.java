/*
 *         File : BeanMain.java
 *    Classname : BeanMain
 *    Author(s) : eznlzhi
 *      Created : 2018-06-22
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

package com.example.testframe.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BeanMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("static/Beans.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld");
        System.out.println(helloWorld);
        System.out.println(helloWorld2);
        String say = helloWorld.getSay();
        String say2 = helloWorld2.getSay();
        System.out.println(say);
        System.out.println(say2);

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("static/Beans.xml"));
        HelloWorld helloWorld3 = (HelloWorld) factory.getBean("helloWorld");
        System.out.println(helloWorld3.getSay());

    }
}
