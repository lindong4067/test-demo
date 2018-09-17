/*
 *         File : ServiceInstance.java
 *    Classname : ServiceInstance
 *    Author(s) : eguopen
 *      Created : 2018-01-03
 *
 * Copyright (c) 2018 Ericsson AB, Sweden.
 * All rights reserved.
 * The Copyright to the computer program(s) herein is the property of
 * Ericsson AB, Sweden.
 * The program(s) may be used and/or copied with the written permission
 * from Ericsson AB or in accordance with the terms and conditions 
 * stipulated in the agreement/contract under which the program(s) 
 * have been supplied.
 *
 */
package com.example.testjson.oam;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ServiceInstance {
    /**
     * the id the service.
     */
    @JsonProperty("Service.ID")
    private String id;

    /**
     * the name of the service.
     */
    private String name;

    /**
     * the tags of the service.
     */
    private List<String> tags;

    /**
     * host name or ip address of the registered micro service
     */
    private String address;

    /**
     * the port of the registered micro service
     */
    private Integer port;

//    /**
//     * specifies a check.
//     */
//    private Map<String, String> check;

    /**
     * specifies checks.
     */
    private List<Map<String, String>> checks;

    /**
     * key value pair meta data associated with the service
     */
    private Map<String, Object> metaData;


}
