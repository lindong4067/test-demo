/*
 *         File : GetConfig.java
 *    Classname : GetConfig
 *    Author(s) : EZNLZHI
 *      Created : 2018-11-13
 *
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
