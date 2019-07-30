package com.example.testpractice.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 从一个数组中返回两个值相加等于目标值的下标
 *
 * @author Lindong Zhao
 * @create 2019-07-28 12:39
 **/
public class TwoSum {
    /**
     * 使用Map缓存做算法，复杂度O(N)
     * @return
     */
    public static int[] getTwo(int[] nums, int target) {
        Map<Integer, Integer> tmpMap = new HashMap<>();
        int[] indexs = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (tmpMap.containsKey(nums[i])) {
                indexs[0] = tmpMap.get(nums[i]);
                indexs[1] = i;
                return indexs;
            }
            tmpMap.put(key, i);
        }
        return indexs;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int target = 8;
        int[] twoIndex = getTwo(nums, target);
        System.out.println("Get two: " + twoIndex[0] + " " + twoIndex[1]);
    }
}
