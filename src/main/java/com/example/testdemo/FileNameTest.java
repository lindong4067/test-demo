
package com.example.testdemo;


public class FileNameTest {

    public static boolean isValidFileName(String fileName) {
        if (fileName == null || fileName.length() > 255) {
            return false;
        } else {
            return fileName.matches("[^\\s\\\\/:\\*\\?\\\"<>\\|](\\x20|[^\\s\\\\:\\*\\?\\\"<>\\|])*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$");
        }
    }

    public static boolean isFileName(String fileName) {
        if (fileName == null || fileName.equals("") || fileName.length() > 255) {
            return false;
        } else if (fileName.equals(" ")){
            return false;
        } else if(fileName.startsWith(" ") || fileName.endsWith(" ") || fileName.endsWith("/")){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String fileName1 = " ";
        String fileName2 = "";
        String fileName3 = "\\ ";
        String fileName4 = " \\";
        String fileName5 = "aaa";
        String fileName6 = "aaa.bbb";
        String fileName7 = "aaa/bbb";
        String fileName8 = "/aaa/bbb";
        String fileName9 = "aaa/bbb/";
        String fileName10 = null;
        boolean valid1 = isFileName(fileName1);
        boolean valid2 = isFileName(fileName2);
        boolean valid3 = isFileName(fileName3);
        boolean valid4 = isFileName(fileName4);
        boolean valid5 = isFileName(fileName5);
        boolean valid6 = isFileName(fileName6);
        boolean valid7 = isFileName(fileName7);
        boolean valid8 = isFileName(fileName8);
        boolean valid9 = isFileName(fileName9);
        boolean valid10 = isFileName(fileName10);
        System.out.println(valid1);
        System.out.println(valid2);
        System.out.println(valid3);
        System.out.println(valid4);
        System.out.println(valid5);
        System.out.println(valid6);
        System.out.println(valid7);
        System.out.println(valid8);
        System.out.println(valid9);
        System.out.println(valid10);
    }
}
