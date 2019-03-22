package com.example.testdemo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StructData {
    enum Colour {
        BLUE, RED, BLACK
    }
    List list = new ArrayList();
    Map map = new HashMap();

    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s", element);
        }
        System.out.println(" end");
    }
    //泛型方法
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static class Box<T> {
        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public static void getData(List<?> data) {
        System.out.printf("Data: %s\n", data.get(0));
    }

    public static void getUperNumber(List<? extends Number> data) {
        System.out.printf("Data: %s\n", data.get(0));
    }

    public static void main(String[] args) {
        // 创建不同类型数组： Integer, Double 和 Character
//        Integer[] intArray = { 1, 2, 3, 4, 5 };
//        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
//        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

//        System.out.println( "整型数组元素为:" );
//        printArray( intArray  ); // 传递一个整型数组

//        System.out.println( "\n双精度型数组元素为:" );
//        printArray( doubleArray ); // 传递一个双精度型数组

//        System.out.println( "\n字符型数组元素为:" );
//        printArray( charArray ); // 传递一个字符型数组

//        Integer integer = maximum(3, 4, 5);
//        System.out.printf("最大值: %s", integer);

//        Double aDouble = maximum(6.6, 7.7, 8.8);
//        System.out.printf("最大值: %s", aDouble);

//        String s = maximum("peer", "apple", "orange");
//        System.out.printf("最大值: %s", s);

//        Box<Integer> integerBox = new Box<>();
//        integerBox.setT(111);
//        Box<String> stringBox = new Box<>();
//        stringBox.setT("222");

        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);

//        getUperNumber(name);
        getUperNumber(age);
        getUperNumber(number);


    }
}
