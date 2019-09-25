package com.example.testeffective.leetcode._001_two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tmpMap = new HashMap<>();
        int[] indexs = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (tmpMap.containsKey(target - nums[i])) {
                indexs[0] = tmpMap.get(target - nums[i]);
                indexs[1] = i;
                return indexs;
            }
            tmpMap.put(nums[i], i);
        }
        return indexs;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
