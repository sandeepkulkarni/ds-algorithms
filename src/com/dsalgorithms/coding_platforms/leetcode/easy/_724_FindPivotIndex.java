package com.dsalgorithms.coding_platforms.leetcode.easy;

/**
 Duplicate of 1991. Find the Middle Index in Array
 ------------------------------------------------------------------------
 Given an array of integers nums, calculate the pivot index of this array.

 The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the
 sum of all the numbers strictly to the index's right.

 If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
 This also applies to the right edge of the array. Return the leftmost pivot index.

 If no such index exists, return -1.

 Example 1:

 Input: nums = [1,7,3,6,5,6]
 Output: 3
 Explanation:
 The pivot index is 3.
 Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 Right sum = nums[4] + nums[5] = 5 + 6 = 11


 Example 2:

 Input: nums = [1,2,3]
 Output: -1
 Explanation:
 There is no index that satisfies the conditions in the problem statement.


 Example 3:

 Input: nums = [2,1,-1]
 Output: 0
 Explanation:
 The pivot index is 0.
 Left sum = 0 (no elements to the left of index 0)
 Right sum = nums[1] + nums[2] = 1 + -1 = 0
 ---------------------------------------------------------------------------------------------------------------------
 Approach:
 https://leetcode.com/problems/find-pivot-index/discuss/411318/Java%3A-beats100-1ms-easy-understanding-solution

 - We have two arrays. Left one we sum from left to right. Right one we sum from right to left.
 - The idea is if pivot exsist, leftside + pivot = rightside + pivot.

 For example, arr = [1, 3, 7, 6, 5, 6]
 left = [1, 4, 11 ,17, 22, 28]
 right = [28, 27, 24, 17, 11, 6]
 If there is a pivot, it should have the same index, then we return it, otherwise return -1;

 TC: O(n)
 SC: O(n)

 Modified: We can actually save extra space by maintaining TOTAL variable and checking is total is same before minus.
 If same means we are at pivot position
 */
public class _724_FindPivotIndex {

    public static void main(String[] args) {
        _724_FindPivotIndex obj = new _724_FindPivotIndex();
        int[] nums = {1,-1,4};//{1, 3, 7, 6, 5, 6};
        System.out.println(obj.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int i=0; i < nums.length; i++){
            total += nums[i];
        }

        int leftSum = 0;
        for(int i=0; i < nums.length; i++){
            total -= nums[i];               //subtract nums[i] from total so basically total will contain rightSum
            if(leftSum == total){           //check if same value then we are at pivot
                return i;
            }
            leftSum += nums[i];                //add to leftSum to check total again
        }
        return -1;
    }
}
