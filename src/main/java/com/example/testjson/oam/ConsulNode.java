/*
 *         File : ConsulNode.java
 *    Classname : ConsulNode
 *    Author(s) : eznlzhi
 *      Created : 2018-08-08
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

public class ConsulNode {

    @JsonProperty("host_name")
    private String hostName;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("host_om_ip")
    private String hostOmIp;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getHostOmIp() {
        return hostOmIp;
    }

    public void setHostOmIp(String hostOmIp) {
        this.hostOmIp = hostOmIp;
    }

    @Override
    public String toString() {
        return "ConsulNode {" + "hostName=" + hostName + ", displayName=" + displayName + ", hostOmIp='" + hostOmIp + "}";
    }
}
