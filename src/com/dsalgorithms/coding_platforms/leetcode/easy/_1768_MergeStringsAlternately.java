package com.dsalgorithms.coding_platforms.leetcode.easy;

/*
 https://leetcode.com/problems/merge-strings-alternately
 
 You are given two strings word1 and word2.
 Merge the strings by adding letters in alternating order, starting with
 word1.
 If a string is longer than the other, append the additional letters onto the
 end of the merged string.
 
 Return the merged string.
 
 Example 1:
    Input: word1 = "abc", word2 = "pqr"
    Output: "apbqcr"
    Explanation: The merged string will be merged as so:
    word1: a b c
    word2: p q r
    merged: a p b q c r
 */
public class _1768_MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        if (word1 == null || word1.length() == 0) {
            return word2;
        } else if (word2 == null || word2.length() == 0) {
            return word1;
        }

        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i));
            i++;
            sb.append(word2.charAt(j));
            j++;
        }
        if (i < word1.length()) {
            sb.append(word1, i, word1.length());
        }
        if (j < word2.length()) {
            sb.append(word2, j, word2.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String word1 = "abcd", word2 = "pq";

        _1768_MergeStringsAlternately obj = new _1768_MergeStringsAlternately();
        System.out.println(obj.mergeAlternately(word1, word2));
    }

}
