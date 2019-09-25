package com.example.testeffective.myrpc.provider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RpcRequest {
    private String interfaceIdentity;

    private Map<String, Object> parameterMap = new HashMap<>();

    private ChannelHandlerContext ctx;

    private String requestId;

    public static RpcRequest parse(String message, ChannelHandlerContext ctx) throws ClassNotFoundException {
        JSONObject jsonObject = JSONArray.parseObject(message);
        String anInterface = jsonObject.getString("interface");
        JSONObject parameter = jsonObject.getJSONObject("parameter");
        Set<String> strings = parameter.keySet();
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setInterfaceIdentity(anInterface);
        Map<String, Object> parameterMap = new HashMap<>(16);
        String requestId = jsonObject.getString("requestId");
        for (String key : strings) {
            if (key.equals("java.lang.String")) {
                parameterMap.put(key, parameter.getString(key));
            } else {
                Class<?> aClass = Class.forName(key);
                Object object = parameter.getObject(key, aClass);
                parameterMap.put(key, object);
            }
        }
        rpcRequest.setParameterMap(parameterMap);
        rpcRequest.setCtx(ctx);
        rpcRequest.setRequestId(requestId);
        return rpcRequest;
    }

    public String getInterfaceIdentity() {
        return interfaceIdentity;
    }

    public void setInterfaceIdentity(String interfaceIdentity) {
        this.interfaceIdentity = interfaceIdentity;
    }

    public Map<String, Object> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(Map<String, Object> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
