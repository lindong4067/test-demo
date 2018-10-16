package com.example.testdemo;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class EnvironmentVariables {

//    private static final String DEFINATION_FILE = "/var/opt/setup/site.export";
    private static final String DEFINATION_FILE = "C:\\Temp\\site.export";

    private static final Properties properties = new Properties();


    static {
        try(FileInputStream fis = new FileInputStream(DEFINATION_FILE)) {
            properties.load(fis);
        } catch (IOException e){
            log.debug(e.getMessage());
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

}
