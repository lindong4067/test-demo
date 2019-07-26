/*
 *         File : JsonUtils.java
 *    Classname : JsonUtils
 *    Author(s) : eznlzhi
 *      Created : 2017-12-21
 *
 *
 */
package com.example.testjson.oam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class JsonUtils {
    public static ObjectMapper objectMapper;

    public static <T> T readValue(String jsonStr, Class<T> clazz){
        if(jsonStr == null){
            return null;
        }
        if(objectMapper == null){
            objectMapper = new ObjectMapper();
        }
        try{
            return objectMapper.readValue(jsonStr, clazz);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T readValue(String jsonStr, TypeReference typeReference){

        if(jsonStr == null){
            return null;
        }
        if(objectMapper == null){
            objectMapper = new ObjectMapper();
        }
        try{
            return objectMapper.readValue(jsonStr, typeReference);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String toJson(Object object){
        if (object == null){
            return null;
        }
        if(objectMapper == null){
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //jsonstring to objList
    public  static <T> Object toObj(String jsonString, Class clazz){
        T obj = null;
        if(objectMapper == null){
            objectMapper = new ObjectMapper();
        }
        try {
            obj = (T) objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        } catch (NullPointerException e){
            e.printStackTrace();
            throw new NullPointerException();
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return obj;
    }
}
