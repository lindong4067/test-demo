/*
 *         File : ServiceInstance.java
 *    Classname : ServiceInstance
 *    Author(s) : eguopen
 *      Created : 2018-01-03
 *
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
