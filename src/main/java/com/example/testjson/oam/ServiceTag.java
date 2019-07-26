/*
 *         File : ServiceTag.java
 *    Classname : ServiceTag
 *    Author(s) : ejmnoqn
 *      Created : 2018-04-08
 *
 *
 */
package com.example.testjson.oam;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ServiceTag {

    public static class FDSServer {

        @SerializedName("fds")
        private String fds;
        @SerializedName("ip")
        private String ip;
        @SerializedName("hostname")
        private String hostname;
        @SerializedName("components")
        private Map<String, String> components;

        public String getFds() {
            return fds;
        }

        public void setFds(String fds) {
            this.fds = fds;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getHostname() {
            return hostname;
        }

        public void setHostname(String hostname) {
            this.hostname = hostname;
        }

        public Map<String, String> getComponents() {
            return components;
        }

        public void setComponents(Map<String, String> components) {
            this.components = components;
        }
    }

    @SerializedName("version")
    private String version;
    @SerializedName("oam-fds--fdsserver")
    private FDSServer fdsServer;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public FDSServer getFdsServer() {
        return fdsServer;
    }

    public void setFdsServer(FDSServer fdsServer) {
        this.fdsServer = fdsServer;
    }
}
