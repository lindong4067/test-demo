package com.example.testpractice.enume;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public enum EnumTest {
    MON(1), TUE(2), WED(3), THU(4), FRI(5),
    SAT(6) {
        @Override
        public boolean isRest() {
            return true;
        }
    },
    SUN(0) {
        @Override
        public boolean isRest() {
            return true;
        }
    };

    private int value;

    EnumTest(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isRest() {
        return false;
    }
}
class Test {
    public static void main(String[] args) {
        System.out.println("EnumTest.FRI 的 value = " + EnumTest.FRI.getValue());
        System.out.println("EnumTest.FRI 的 isRest = " + EnumTest.FRI.isRest());

        EnumSet<EnumTest> weekSet = EnumSet.allOf(EnumTest.class);
        for (EnumTest day : weekSet) {
            System.out.println(day);
        }

        EnumMap<EnumTest, String> weekMap = new EnumMap(EnumTest.class);
        weekMap.put(EnumTest.MON, "星期一");
        weekMap.put(EnumTest.TUE, "星期二");
        for (Map.Entry<EnumTest, String> entry : weekMap.entrySet()) {
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
    }
}
