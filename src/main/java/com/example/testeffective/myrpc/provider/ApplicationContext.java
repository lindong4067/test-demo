package com.example.testeffective.myrpc.provider;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    private List<ServiceConfig> serviceConfigs;
    private Integer port = 8080;
    private NettyServer nettyServer;

    public ApplicationContext(String registerUrl, List serviceConfigs) throws Exception {
        // 1 保存需要暴露的接口配置
        this.serviceConfigs = serviceConfigs == null ? new ArrayList<>() : serviceConfigs;
        // 2 实例化注册中心
        initRegistry(registerUrl);
        // 3 将接口注册到注册中心，从注册中心获取接口，初始化服务接口列表
        InetAddress addr = InetAddress.getLocalHost();
        String hostName = addr.getHostName();
        String hostAddress = addr.getHostAddress();
        RegistryInfo registryInfo = new RegistryInfo(hostName, hostAddress, port);
        doRegistry(registryInfo);
        // 4 初始化服务器，接受请求，
        if (!this.serviceConfigs.isEmpty()) {
        nettyServer = new NettyServer(this.serviceConfigs, interfaceMethods);
        nettyServer.init(port);
        }

    }

    // 接口方法对应method对象
    private Map<String, Method> interfaceMethods = new ConcurrentHashMap<>();

    private void doRegistry(RegistryInfo registryInfo) throws Exception {
        for (ServiceConfig serviceConfig : serviceConfigs) {
            Class type = serviceConfig.getType();
            registry.register(type, registryInfo);
            Method[] methods = type.getDeclaredMethods();
            for (Method method : methods) {
                String identify = InvokeUtils.buildInterfaceMethodIdentify(type, method);
                interfaceMethods.put(identify, method);
            }
        }
    }

    private Registry registry;

    private void initRegistry(String registerUrl) {
        if (registerUrl.startsWith("zookeeper://")) {
            registerUrl = registerUrl.substring(12);
            registry = new ZookeeperRegistry(registerUrl);
        } else if (registerUrl.startsWith("multicast://")) {
            registry = new MulticastRegistry(registerUrl);
        }
    }
}
