package com.dsalgorithms.coding_platforms.leetcode.easy;

/**
 Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

 A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 of the characters without disturbing the relative positions of the remaining characters.
 (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 Input: s = "abc", t = "ahbgdc"
 Output: true

 Example 2:
 Input: s = "axc", t = "ahbgdc"
 Output: false
---------------------------------------
 Approach:


 Iterate through t and increment s if the current s matches t.
 If you exhaust t you have failed, if you exhaust s you have succeeded.

 */
public class _392_Is_Subsequence {

    public static void main(String[] args) {
        _392_Is_Subsequence obj = new _392_Is_Subsequence();
        String s = "axc", t = "ahbgdc";
        System.out.println(obj.isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {       //Empty strong s is subsequence so True
            return true;
        }
        int indexT = 0;
        int indexS = 0;
        while(indexT < t.length()){
            if(s.charAt(indexS) == t.charAt(indexT)){   //chars match
                indexS++;
                if(indexS == s.length()){   //substring over correctly, so True
                    return true;
                }
            }
            indexT++;
        }
        return false;       //else false by default
    }
}
