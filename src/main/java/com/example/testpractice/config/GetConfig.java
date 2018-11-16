/*
 *         File : GetConfig.java
 *    Classname : GetConfig
 *    Author(s) : EZNLZHI
 *      Created : 2018-11-13
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

package com.example.testpractice.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

public class GetConfig {
    public static void main(String[] args) {
        //Config tsConfig = ConfigFactory.load().resolve(); default
        Config tsConfig = ConfigFactory.parseFile(new File("config/cfg.conf")).resolve();
        Config service = tsConfig.getConfig("service");
        String url = service.getString("url");
        System.out.println("service.url : " + url);
        int poolSize = service.getInt("poolSize");
        System.out.println("service.poolSize : " + poolSize);
        boolean debug = service.getBoolean("debug");
        System.out.println("service.debug : " + debug);
        double factor = service.getDouble("factor");
        System.out.println("servce.factor : " + factor);
    }
}
