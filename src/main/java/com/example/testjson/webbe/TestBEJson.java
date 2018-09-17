package com.example.testjson.webbe;

import com.google.gson.*;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class TestBEJson {
    public static void main(String[] args) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("static/result_gmpc.json");
        // InputStream
        InputStream in = classPathResource.getInputStream();
        byte[] b = new byte[1024];
        int tempByte;

        StringBuilder sb = new StringBuilder();
        while ((tempByte = in.read(b)) != -1) {
            sb.append(new String(b, 0, tempByte, "utf-8"));
        }
        in.close();

        String result = sb.toString();
        // System.out.println(result);
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(result);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        filterResultData("system_operator", jsonObject);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(jsonObject));
    }

    private static void filterResultData(String roleId, JsonObject jsonObject) {
        if (jsonObject == null){
            return;
        }
        JsonObject loginInfo = jsonObject.getAsJsonObject(SysContants.COMMON_LOGININFO);
        if (loginInfo == null){
            return;
        }
        JsonObject userInfo = loginInfo.getAsJsonObject(SysContants.COMMON_USERINFO);
        JsonArray menuInfo = loginInfo.getAsJsonArray(SysContants.COMMON_MENUINFO);
        if (userInfo == null || menuInfo == null){
            return;
        }
        if (SysContants.COMMON_ACCOUNT_ADMIN.equals(roleId)){
            for (int i = menuInfo.size() - 1; i >= 0; i--) {
                JsonElement jsonElement = menuInfo.get(i);
                JsonObject menu = jsonElement.getAsJsonObject();
                JsonObject group = menu.getAsJsonObject(SysContants.COMMON_GROUP);
                String name = group.get(SysContants.COMMON_NAME).getAsString();
                if (!SysContants.COMMON_USER_MANAGEMENT.equals(name)){
                    menuInfo.remove(jsonElement);
                }

            }

        }else if (SysContants.COMMON_STATISTICS_ADMIN.equals(roleId)){
            for (int i = menuInfo.size() - 1; i >= 0; i--) {
                JsonElement jsonElement = menuInfo.get(i);
                JsonObject menu = jsonElement.getAsJsonObject();
                JsonObject group = menu.getAsJsonObject(SysContants.COMMON_GROUP);
                String name = group.get(SysContants.COMMON_NAME).getAsString();
                if (SysContants.COMMON_SYSTEM_RECORDS.equals(name)){
                    JsonArray groupArray = group.getAsJsonArray(SysContants.COMMON_GROUP);
                    for (int j = groupArray.size() - 1; j >= 0; j--) {
                        JsonElement element = groupArray.get(j);
                        JsonObject ele = element.getAsJsonObject();
                        String na = ele.get(SysContants.COMMON_NAME).getAsString();
                        if (!SysContants.COMMON_STATISTICS.equals(na)){
                            groupArray.remove(element);
                        }
                    }
                }else {
                    menuInfo.remove(jsonElement);
                }

            }

        }else if(SysContants.COMMON_SMPC_CELL_DATA_ADMIN.equals(roleId) || SysContants.COMMON_GMPC_CELL_DATA_ADMIN.equals(roleId)){
            for (int i = menuInfo.size() - 1; i >= 0; i--) {
                JsonElement jsonElement = menuInfo.get(i);
                JsonObject menu = jsonElement.getAsJsonObject();
                JsonObject group = menu.getAsJsonObject(SysContants.COMMON_GROUP);
                String name = group.get(SysContants.COMMON_NAME).getAsString();
                if (SysContants.COMMON_DATA_MANAGEMENT.equals(name)){
                    JsonArray groupArray = group.getAsJsonArray(SysContants.COMMON_GROUP);
                    for (int j = groupArray.size() - 1; j >= 0; j--) {
                        JsonElement element = groupArray.get(j);
                        JsonObject ele = element.getAsJsonObject();
                        String na = ele.get(SysContants.COMMON_NAME).getAsString();
                        if (!SysContants.COMMON_CELL_DATA.equals(na)){
                            groupArray.remove(element);
                        }
                    }
                }else {
                    menuInfo.remove(jsonElement);
                }
            }

        }else if(SysContants.COMMON_GMPC_NETWORK_ADMIN.equals(roleId)){
            for (int i = menuInfo.size() - 1; i >= 0; i--) {
                JsonElement jsonElement = menuInfo.get(i);
                JsonObject menu = jsonElement.getAsJsonObject();
                JsonObject group = menu.getAsJsonObject(SysContants.COMMON_GROUP);
                String name = group.get(SysContants.COMMON_NAME).getAsString();
                if (SysContants.COMMON_DATA_MANAGEMENT.equals(name)){
                    JsonArray groupArray = group.getAsJsonArray(SysContants.COMMON_GROUP);
                    for (int j = groupArray.size() - 1; j >= 0; j--) {
                        JsonElement element = groupArray.get(j);
                        JsonObject ele = element.getAsJsonObject();
                        String na = ele.get(SysContants.COMMON_NAME).getAsString();
                        if (!SysContants.COMMON_NETWORK_DATA.equals(na)){
                            groupArray.remove(element);
                        }
                    }
                }else {
                    menuInfo.remove(jsonElement);
                }
            }

        }else if(SysContants.COMMON_GMPC_CLIENT_ADMIN.equals(roleId)){
            for (int i = menuInfo.size() - 1; i >= 0; i--) {
                JsonElement jsonElement = menuInfo.get(i);
                JsonObject menu = jsonElement.getAsJsonObject();
                JsonObject group = menu.getAsJsonObject(SysContants.COMMON_GROUP);
                String name = group.get(SysContants.COMMON_NAME).getAsString();
                if (SysContants.COMMON_DATA_MANAGEMENT.equals(name)){
                    JsonArray groupArray = group.getAsJsonArray(SysContants.COMMON_GROUP);
                    for (int j = groupArray.size() - 1; j >= 0; j--) {
                        JsonElement element = groupArray.get(j);
                        JsonObject ele = element.getAsJsonObject();
                        String na = ele.get(SysContants.COMMON_NAME).getAsString();
                        if (!SysContants.COMMON_CLIENT_DATA.equals(na)){
                            groupArray.remove(element);
                        }
                    }
                }else {
                    menuInfo.remove(jsonElement);
                }
            }

        }else if (SysContants.COMMON_SYSTEM_OBSERVER.equals(roleId)){
            for (int i = menuInfo.size() - 1; i >= 0; i--) {
                JsonElement jsonElement = menuInfo.get(i);
                JsonObject menu = jsonElement.getAsJsonObject();
                JsonObject group = menu.getAsJsonObject(SysContants.COMMON_GROUP);
                String name = group.get(SysContants.COMMON_NAME).getAsString();
                if (SysContants.COMMON_USER_MANAGEMENT.equals(name)){
                    menuInfo.remove(jsonElement);
                }else if (SysContants.COMMON_SYSTEM_MONITOR.equals(name)){
                    JsonArray groupArray = group.getAsJsonArray(SysContants.COMMON_GROUP);
                    for (int j = groupArray.size() - 1; j >= 0; j--) {
                        JsonElement element = groupArray.get(j);
                        JsonObject ele = element.getAsJsonObject();
                        String na = ele.get(SysContants.COMMON_NAME).getAsString();
                        if (SysContants.COMMON_ALARM_LIST.equals(na) || SysContants.COMMON_ALARM_SETTINGS.equals(na)){
                            groupArray.remove(element);
                        }
                    }
                }
            }
        }else if (SysContants.COMMON_SYSTEM_OPERATOR.equals(roleId)){
            for (int i = menuInfo.size() - 1; i >= 0; i--) {
                JsonElement jsonElement = menuInfo.get(i);
                JsonObject menu = jsonElement.getAsJsonObject();
                JsonObject group = menu.getAsJsonObject(SysContants.COMMON_GROUP);
                String name = group.get(SysContants.COMMON_NAME).getAsString();
                if (SysContants.COMMON_USER_MANAGEMENT.equals(name)){
                    menuInfo.remove(jsonElement);
                }
            }
        }else if (SysContants.COMMON_FLEXCONN_ADMIN.equals(roleId)){
            for (int i = menuInfo.size() - 1; i >= 0; i--) {
                JsonElement jsonElement = menuInfo.get(i);
                JsonObject menu = jsonElement.getAsJsonObject();
                JsonObject group = menu.getAsJsonObject(SysContants.COMMON_GROUP);
                String name = group.get(SysContants.COMMON_NAME).getAsString();
                if (SysContants.COMMON_SOFTWARE_MANAGEMENT.equals(name)){
                    JsonArray groupArray = group.getAsJsonArray(SysContants.COMMON_GROUP);
                    for (int j = groupArray.size() - 1; j >= 0; j--) {
                        JsonElement element = groupArray.get(j);
                        groupArray.remove(element);
                    }
                }else {
                    menuInfo.remove(jsonElement);
                }

            }
        }
    }

}
