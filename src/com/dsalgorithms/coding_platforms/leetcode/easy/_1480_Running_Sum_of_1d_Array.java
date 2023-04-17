package com.dsalgorithms.coding_platforms.leetcode.easy;
import java.util.Arrays;

/**
 Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

 Return the running sum of nums.

 Example 1:

 Input: nums = [1,2,3,4]
 Output: [1,3,6,10]
 Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

 https://leetcode.com/problems/running-sum-of-1d-array/solution/
 */
public class _1480_Running_Sum_of_1d_Array {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        _1480_Running_Sum_of_1d_Array obj = new _1480_Running_Sum_of_1d_Array();
        System.out.println("Running Sum: " + Arrays.toString(obj.runningSum(nums)));
    }

    /*
    Optimized using Momoization: using the result computed in previous index and just adding to it.
    So we only need to iterate nums[] once.
    */
    public int[] runningSum(int[] nums) {
        int size = nums.length;
        int[] runningSum = new int[size];

        for(int i=0; i < size; i++){    //loop through all index of nums
            if(i == 0){
                runningSum[i] = nums[i];
            }else{
                runningSum[i] = runningSum[i-1] + nums[i];
            }
        }
        return runningSum;

        //Optimized version: Time complexity: O(n)
    }

    /* Brute Force: We are looping and finding sum everytime from index 0
    ** Can use momoization to avoid rework

    public int[] runningSum(int[] nums) {
        int size = nums.length;
        int[] runningSum = new int[size];

        for(int i=0; i < size; i++){    //loop through all index of nums
            int sum = 0;
           for(int j=0; j <= i; j++){       //loop from 0...nums[i] to find runningSum
              sum += nums[j];
           }
           runningSum[i] = sum;
        }
        return runningSum;
        //Time complexity: O(n^2)
    }
    */
}
