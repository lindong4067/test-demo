
package com.example.testdemo;

import java.util.*;

public class CompareTest {

    public static boolean compareListOfMap(List<Map> listA, List<Map> listB) {
        Set<Map> setA = new LinkedHashSet<>(listA);
        Set<Map> setB = new LinkedHashSet<>(listB);

        return setA.containsAll(setB) && setB.containsAll(setA);
    }

    public static boolean compareListOfMap2(List<Map> listA, List<Map> listB){
        for (Map map : listA) {
            if (!listB.contains(map)){
                return false;
            }
        }
        for (Map map : listB) {
            if (!listA.contains(map)){
                return false;
            }
        }
        return true;
    }

    public static boolean compareListOfMap3(List<Map> listA, List<Map> listB){
        if (listA.size() != listB.size()){
            return false;
        }
        int same = 0;
        for (Map map1 : listA) {
            System.out.println("map1 --> " + map1);
            out:for (Map map2 : listB) {
                System.out.println("map2 --> " + map2);
                for (Object o1 : map1.entrySet()) {
                    System.out.println("o1 --> " + o1);
                    for (Object o2 : map2.entrySet()) {
                        System.out.println("o2 --> " + o2);
                        System.out.println(o1 + "  <---->  " + o2);
                        if (o1.equals(o2)){
                            System.out.println("比对成功一个");
                            same++;
                            break out;
                        }
                    }
                }
            }
        }
        return same == listA.size();
    }

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("k1", "v1");
        Map<String, String> map2 = new HashMap<>();
        map2.put("k2", "v2");
        Map<String, String> map3 = new HashMap<>();
        map3.put("k3", "v3");
        Map<String, String> map4 = new HashMap<>();
        map4.put("k4", "v4");

        List<Map> list1 = new ArrayList<>();
        list1.add(map1);
        list1.add(map2);
        list1.add(map3);

        List<Map> list2 = new ArrayList<>();
        list2.add(map1);
        list2.add(map3);
        list2.add(map4);

        boolean compareListOfMap = compareListOfMap3(list1, list2);
        System.out.println(compareListOfMap);
    }
}
