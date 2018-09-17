/*
 *         File : Member.java
 *    Classname : Member
 *    Author(s) : ejmnoqn
 *      Created : 2018-03-07
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
package com.example.testjson.oam;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Member {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Addr")
    private String address;

    @JsonProperty("Port")
    private Integer port;

    @JsonProperty("Tags")
    private Map<String, String> tags;

    @JsonProperty("Status")
    private int status;

    @JsonProperty("ProtocolMin")
    private int protocolMin;

    @JsonProperty("ProtocolMax")
    private int protocolMax;

    @JsonProperty("ProtocolCur")
    private int protocolCur;

    @JsonProperty("DelegateMin")
    private int delegateMin;

    @JsonProperty("DelegateMax")
    private int delegateMax;

    @JsonProperty("DelegateCur")
    private int delegateCur;
}
