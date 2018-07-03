
package com.example.testdemo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Passworld {
    // OMCenter
    public static void main(String[] args) {
        String password = encodeHash("$%Paper37");
        System.out.println(password);
    }

    public static String encodeHash(String theWords) {

        try {
            return encrypt_sha1(theWords + encrypt_sha1("Budapest"));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String encrypt_sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");

        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length / 4; i++) {
            sb.append(Integer.toString((result[i * 4 + 3] & 0xff) + 0x100, 16).substring(1));
            sb.append(Integer.toString((result[i * 4 + 2] & 0xff) + 0x100, 16).substring(1));
            sb.append(Integer.toString((result[i * 4 + 1] & 0xff) + 0x100, 16).substring(1));
            sb.append(Integer.toString((result[i * 4] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
