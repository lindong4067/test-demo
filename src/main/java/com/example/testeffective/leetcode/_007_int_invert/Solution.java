package com.example.testeffective.leetcode._007_int_invert;

public class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int reverse = solution.reverse(-12345);
        System.out.println(reverse);
    }
}
