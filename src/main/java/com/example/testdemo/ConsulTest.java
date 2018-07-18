/*
 *         File : ConsulTest.java
 *    Classname : ConsulTest
 *    Author(s) : eznlzhi
 *      Created : 2018-07-06
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

package com.example.testdemo;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import org.junit.Assert;
import org.junit.Test;

public class ConsulTest {

    @Test
    public void test01(){
        ConsulClient client = new ConsulClient();
        String k1 = "cm/values/18-gmpc-cluster/datastorages/NetworkStorage_IPStorage/cluster/http://127.0.0.1:1219";
        String v1 = "001";
        String k2 = "002";
        String v2 = "002";
        Response<Boolean> response = client.setKVValue(k1, v1);
        Assert.assertEquals(Boolean.TRUE, response.getValue());
    }
}
