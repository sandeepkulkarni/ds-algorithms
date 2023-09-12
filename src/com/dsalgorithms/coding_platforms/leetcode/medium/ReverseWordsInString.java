package com.dsalgorithms.coding_platforms.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * 151. Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString obj = new ReverseWordsInString();

        String input = "the sky is blue";
        System.out.println("Input: " + input);

        String reverse = obj.reverseWords(input);
        System.out.println(reverse);
    }

    // Approach 1: Using Built-in functions
    /*public String reverseWords(String s) {
        // remove leading and trailing spaces
        s = s.trim();
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }*/

    // Approach 2: The most straightforward one. Trim the whitespaces, reverse the
    // whole string and then reverse each word.
    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // remove leading spaces
        while (left <= right && s.charAt(left) == ' ')
            ++left;

        // remove trailing spaces
        while (left <= right && s.charAt(right) == ' ')
            --right;

        // reduce multiple spaces to single one
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' '){
                sb.append(c);
            }else if (sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // go to the end of the word
            while (end < n && sb.charAt(end) != ' ')
                ++end;
            // reverse the word
            reverse(sb, start, end - 1);
            // move to the next word
            start = end + 1;
            ++end;
        }
    }

    public String reverseWords(String s) {
        // converst string to string builder
        // and trim spaces at the same time
        StringBuilder sb = trimSpaces(s);

        // reverse the whole string
        reverse(sb, 0, sb.length() - 1);

        // reverse each word
        reverseEachWord(sb);

        return sb.toString();
    }
}
