package com.dsalgorithms.coding_platforms.leetcode.easy;

/**
 * 409. Longest Palindrome
 https://leetcode.com/problems/longest-palindrome/

 Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

 Letters are case sensitive, for example, "Aa" is not considered a palindrome here.



 Example 1:

 Input: s = "abccccdd"
 Output: 7
 Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

 */
public class _409_LongestPalindrome {

    public static void main(String[] args) {
        _409_LongestPalindrome obj = new _409_LongestPalindrome();
        String s = "abccccddsss";
        System.out.println(obj.longestPalindrome(s));

    }

    public int longestPalindrome(String s) {
        int[] charFreq = new int[128];
        for(char ch : s.toCharArray()) {
            charFreq[ch]++;
        }

        int result = 0;
        //For each letter, say it occurs v times. We know we have v / 2 * 2 letters that can be partnered for sure.
        for(int freq : charFreq){
            result += freq / 2 * 2;

            //we will check for v % 2 == 1 and ans % 2 == 0, the latter meaning we haven't yet added a unique center to the answer.
            if(result % 2 == 0 && freq % 2 == 1){
                result++;
            }
        }
        return result;
    }

}
