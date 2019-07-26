/*
 *         File : ConsulNode.java
 *    Classname : ConsulNode
 *    Author(s) : eznlzhi
 *      Created : 2018-08-08
 *
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
