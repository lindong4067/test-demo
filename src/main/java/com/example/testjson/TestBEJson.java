package com.example.testjson;

import com.google.gson.*;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class TestBEJson {
    public static void main(String[] args) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("static/result.json");
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
//        System.out.println(result);
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(result);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        filterResultData("smpc_celldata_admin", jsonObject);

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
            System.out.println(menuInfo);
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
            System.out.println(menuInfo);
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

        }else if(SysContants.COMMON_SMPC_CELL_DATA_ADMIN.equals(roleId)){
            System.out.println(menuInfo);
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

        }
    }

}
