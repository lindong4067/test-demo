/*
 *         File : PersonTest.java
 *    Classname : PersonTest
 *    Author(s) : eznlzhi
 *      Created : 2018-10-08
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

package com.example.testmock;

import org.junit.Test;

public class PersonTest {

    @Test
    public void testPerson(){
        Person person = new Person();
        person.setId(111).setName("XiaoMing");
        System.out.println(person);
    }
}
