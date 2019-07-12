package com.example.testdemo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 1 两数之和
 */
class SolutionTowSum {
    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        for (int i = 0; i <= nums.length - 2; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    indexs[0] = i;
                    indexs[1] = j;
                    return indexs;
                }
            }
        }
        return indexs;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], i);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (m.containsKey(t) && m.get(t) != i) {
                res[0] = i;
                res[1] = m.get(t);
                break;
            }
        }
        return res;
    }

    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {11, 15, 2, 7};
        int target = 9;
        int[] ints = new SolutionTowSum().twoSum(nums, target);
        System.out.print("[");
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.print("]");
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }
}

/**
 * 2.两数相加
 */
class SolutionAddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);

        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode2.setNext(listNode4);
        listNode4.setNext(listNode3);

        listNode5.setNext(listNode6);
        listNode6.setNext(listNode4);

        SolutionAddTwoNumbers solution = new SolutionAddTwoNumbers();
        ListNode listNode = solution.addTwoNumbers(listNode2, listNode5);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }
}

/**
 * 3.无重复字符的最长子串
 */
class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int i1 = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(i1);
        int i2 = solution.lengthOfLongestSubstring("bbbbb");
        System.out.println(i2);
        int i3 = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(i3);
    }
}









