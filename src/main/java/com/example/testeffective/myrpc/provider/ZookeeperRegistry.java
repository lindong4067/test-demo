package com.example.testeffective.myrpc.provider;

import com.alibaba.fastjson.JSONArray;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ZookeeperRegistry implements Registry {
    private CuratorFramework client;

    public ZookeeperRegistry(String registerUrl) {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient(registerUrl, retryPolicy);
        client.start();
        try {
            Stat myRPC = client.checkExists().forPath("/myRPC");
            if (myRPC == null) {
                client.create()
                        .creatingParentsIfNeeded()
                        .forPath("/myRPC");
            }
            System.out.println("Zookeeper Client Init Ready......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void register(Class clazz, RegistryInfo registryInfo) throws Exception {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String key = InvokeUtils.buildInterfaceMethodIdentify(clazz, method);
            String path = "/myRPC/" + key;
            Stat stat = client.checkExists().forPath(path);
            List<RegistryInfo> registryInfos;
            if (stat != null) {
                byte[] bytes = client.getData().forPath(path);
                String data = new String(bytes, UTF_8);
                registryInfos = JSONArray.parseArray(data, RegistryInfo.class);
                if (registryInfos.contains(registryInfo)) {
                    System.out.println("Value [ " + registryInfo + " ] already exit.");
                } else {
                    registryInfos.add(registryInfo);
                    client.setData().forPath(path, JSONArray.toJSONString(registryInfos).getBytes());
                    System.out.println("Key exit, Register key [ " + key + " ] , value [ " + registryInfo + " ] ");
                }
            } else {
                registryInfos = new ArrayList<>();
                registryInfos.add(registryInfo);
                client.create()
                        .creatingParentsIfNeeded()
                        .withMode(CreateMode.EPHEMERAL)
                        .forPath(path, JSONArray.toJSONString(registryInfos).getBytes());
                System.out.println("Key not exit, Register key [ " + key + " ] , value [ " + registryInfo + " ] ");
            }
        }
    }
}
