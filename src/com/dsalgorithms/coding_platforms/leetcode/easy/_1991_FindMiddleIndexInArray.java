package com.dsalgorithms.coding_platforms.leetcode.easy;

/**
 Duplicate of 724. Find Pivot Index
 ------------------------------------

 Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e., the smallest amongst all the possible ones).

 A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] ==
 nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1].

 If middleIndex == 0, the left side sum is considered to be 0.
 Similarly, if middleIndex == nums.length - 1, the right side sum is considered to be 0.

 Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.

 */
public class _1991_FindMiddleIndexInArray {

    public static void main(String[] args) {
        _1991_FindMiddleIndexInArray obj = new _1991_FindMiddleIndexInArray();
        int[] nums = {2,3,-1,8,4};
        System.out.println(obj.findMiddleIndex(nums));
    }


    public int findMiddleIndex(int[] nums) {
        int total = 0;
        for(int i=0; i < nums.length; i++){
            total += nums[i];
        }

        int left = 0;
        for(int i=0; i < nums.length; i++){
            total -= nums[i];               //subtract from total
            if(left == total){              //check if same value then we are at pivot
                return i;
            }
            left += nums[i];                //add to left to check total again
        }
        return -1;
    }
}
