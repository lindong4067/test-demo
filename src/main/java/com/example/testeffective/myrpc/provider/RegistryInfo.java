package com.example.testeffective.myrpc.provider;

public class RegistryInfo {
    private String hostName;
    private String ip;
    private Integer port;

    public RegistryInfo(String hostName, String ip, Integer port) {
        this.hostName = hostName;
        this.ip = ip;
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
