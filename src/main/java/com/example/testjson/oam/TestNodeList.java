/*
 *         File : TestNodeList.java
 *    Classname : TestNodeList
 *    Author(s) : eznlzhi
 *      Created : 2018-09-06
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

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.*;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestNodeList {

    public static List<ConsulNode> getNodeList(String node) throws Exception {

        String consulJson = readResourceFromClassPath("static/oam/consul_members.json");
        List<Member> consulMembers = JsonUtils.readValue(consulJson, new TypeReference<List<Member>>() {});

        String serviceJson = readResourceFromClassPath("static/oam/service_instances.json");
        List<ConsulNode> consulNodeList = new ArrayList<>();
        if(consulMembers == null || consulMembers.isEmpty()){
            return consulNodeList;
        }

        List<ServiceInstance> serviceInstances = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(serviceJson);
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        for (JsonElement element : jsonArray) {
            JsonObject jsonNode = element.getAsJsonObject();
            JsonObject serviceNode = jsonNode.getAsJsonObject("Service");
            ServiceInstance serviceInstance = new ServiceInstance();
            serviceInstance.setId(serviceNode.get("ID").getAsString());
            serviceInstance.setAddress(serviceNode.get("Address").getAsString());
            JsonArray tagsNode = serviceNode.getAsJsonArray("Tags");
            List<String> tagList = new ArrayList<>();
            for (JsonElement tag : tagsNode) {
                tagList.add(tag.getAsString());
            }
            serviceInstance.setTags(tagList);
            serviceInstance.setName(serviceNode.get("Service").getAsString());
            serviceInstance.setPort(serviceNode.get("Port").getAsInt());
            serviceInstances.add(serviceInstance);
        }

        List<String> aecidHostNames = new ArrayList<>();
        List<String> smpcHostNames = new ArrayList<>();
        List<String> gmpcHostNames = new ArrayList<>();
        Gson gson = new Gson();
        for (ServiceInstance serviceInstance : serviceInstances) {
            ServiceTag serviceTag = gson.fromJson(serviceInstance.getTags().get(0), ServiceTag.class);
            String version = serviceTag.getVersion();
            String hostName = serviceTag.getFdsServer().getHostname();
            if(version.toLowerCase().contains("aecid")){
                aecidHostNames.add(hostName);
            }
            if(version.toLowerCase().contains("smpc")){
                smpcHostNames.add(hostName);
            }
            if(version.toLowerCase().contains("gmpc")){
                gmpcHostNames.add(hostName);
            }
        }
        for (Member member : consulMembers){
            if ("aecid".equalsIgnoreCase(node)
                    && aecidHostNames.contains(member.getName())
                    || "gmpc".equalsIgnoreCase(node)
                    && !aecidHostNames.contains(member.getName())
                    && !gmpcHostNames.isEmpty()
                    || "smpc".equalsIgnoreCase(node)
                    && !aecidHostNames.contains(member.getName())
                    && !smpcHostNames.isEmpty()){
                ConsulNode consulNode = new ConsulNode();
                consulNode.setHostName(member.getName());
                consulNode.setDisplayName(member.getName());
                consulNode.setHostOmIp(member.getAddress());
                consulNodeList.add(consulNode);
            }
        }
        return consulNodeList;
    }

    private static String readResourceFromClassPath(String filePath) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(filePath);
        InputStream inputStream = classPathResource.getInputStream();

        byte[] buffer = new byte[1024];
        int length;
        StringBuilder sb = new StringBuilder();
        while ((length = inputStream.read(buffer)) != -1){
            sb.append(new String(buffer, 0, length, "utf-8"));
        }
        inputStream.close();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        List<ConsulNode> nodeList = getNodeList("gmpc");
        String json = JsonUtils.toJson(nodeList);

        System.out.println(json);
    }
}
