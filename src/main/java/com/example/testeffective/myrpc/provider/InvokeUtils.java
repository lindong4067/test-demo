package com.example.testeffective.myrpc.provider;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class InvokeUtils {
    public static String buildInterfaceMethodIdentify(Class clazz, Method method) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("interface", clazz.getName());
        map.put("method", method.getName());
        Parameter[] parameters = method.getParameters();
        if (parameters.length > 0) {
            StringBuilder param = new StringBuilder();
            for (int i = 0; i < parameters.length; i++) {
                Parameter p = parameters[i];
                param.append(p.getType().getName());
                if (i < parameters.length - 1){
                    param.append(",");
                }
            }
            map.put("parameter", param.toString());
        }
        return mapToString(map);
    }

    private static String mapToString(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            if (iterator.hasNext()) {
                stringBuilder.append("&");
            }
        }
        return stringBuilder.toString();
    }
}
