package com.dsalgorithms.coding_platforms.leetcode.easy;

import java.util.HashMap;
import java.util.Arrays;

/*
1. Two Sum
 https://leetcode.com/problems/two-sum/

Given an array of integers, return indices of the two numbers such that they add up to a specific
target.

You may assume that each input would have exactly one solution.

Example:
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
    
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.
--------------------------------------------------------------------------------------------------------------
Naive Approach:
Outer loop and inner loop to check each number with every other number to see if matches target.
Complexity: O(n^2)

Optimised Approach:
	1. HashMap to store <Target - Num, Num index> and check while inserting num if diff is 0
	2. If diff = 0, get previous value index and current value index and return
*/
public class _1_TwoSum {

    // Approach:
    // 1. HashMap to store <Num, Num index> and check while inserting num if diff is
    // 0
    // 2. If diff = 0, get previous value index and current value index and return
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            if (map.containsKey(target - x)) { // check if target - nums[i] present in map
                int previousIndex = map.get(target - x);
                int[] result = { previousIndex, i };
                return result;
            } else {
                map.put(x, i); // store <num[i], num index> in map
            }
        }
        return null;
    }

    // Approach 2:
    // 1. HashMap to store <Target - Num, Num index> and check while inserting num if diff is 0
    // 2. If diff = 0, get previous value index and current value index and return
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) { // found total target value as we store diff in key
                int previousIndex = map.get(nums[i]);
                int[] result = { previousIndex, i };
                return result;
            } else {
                map.put(target - nums[i], i); // store <target-num, num index>
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 13;

        _1_TwoSum obj = new _1_TwoSum();
        int[] result = obj.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}