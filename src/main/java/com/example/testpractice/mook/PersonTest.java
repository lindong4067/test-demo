/*
 *         File : PersonTest.java
 *    Classname : PersonTest
 *    Author(s) : eznlzhi
 *      Created : 2018-10-08
 *
 *
 */

package com.example.testpractice.mook;

import org.junit.Test;

public class PersonTest {

    @Test
    public void testPerson(){
        Person person = new Person();
        person.setId(111).setName("XiaoMing");
        System.out.println(person);
    }
}
