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
import com.ecwid.consul.v1.kv.model.GetValue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Base64;

public class ConsulTest {

    @Test
    public void test01(){
        ConsulClient client = new ConsulClient();
//        cm/values/18-gmpc-cluster/datastorages/NetworkStorage_IPStorage/cluster/https%253a%252f%252fwww.msc2.com
//        String k1 = "cm/values/18-gmpc-cluster/datastorages/NetworkStorage_IPStorage/cluster/http://127.0.0.1:1219";
        String k1 = "cm/values/18-gmpc-cluster/datastorages/NetworkStorage_IPStorage/cluster/https%253a%252f%252fwww.msc2.com";
        String v1 = "111";
        String k2 = "cm/values/18-gmpc-cluster/datastorages/NetworkStorage_IPStorage/cluster/https%3a%2f%2fwww.baidu.com";
        String v2 = "{\"GMPCAddress\":\"https://www.baidu.com\",\"Id\":\"string\",\"Password\":\"string\",\"Protocol\":\"RLP1.0.0\",\"POIAgreement\":\"1\",\"ResponseType\":\"ASYNC\"}";
        String k3 = "cm/values/18-gmpc-cluster/datastorages/NetworkStorage_IPStorage/cluster/https%253A%252F%252Fwww.baidu.com";
        String v3 = "{\"GMPCAddress\":\"https://www.baidu.com\",\"Id\":\"string\",\"Password\":\"string\",\"Protocol\":\"RLP1.0.0\",\"POIAgreement\":\"1\",\"ResponseType\":\"ASYNC\"}";
        Response<Boolean> response = client.setKVValue(k3, v3);
        Assert.assertEquals(Boolean.TRUE, response.getValue());
        Response<GetValue> value = client.getKVValue(k3);
        System.out.println(value.getValue().getDecodedValue());
//        Assert.assertEquals(v1, value.getValue().getDecodedValue());
    }

//    enum Me{
//        ASD,
//        BNM,
//        CCC;
//
//        public static final String OK = "aaa, OK!";

       /* private String value;
        Me(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }*/
//    }

    @Test
    public void test02(){

    }
}
