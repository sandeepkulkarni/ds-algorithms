package com.dsalgorithms.coding_platforms.leetcode.easy;

import java.util.*;

/**
 Given two strings s and t, determine if they are isomorphic.
 Two strings s and t are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character, but a character may map to itself.

 Example 1:
 Input: s = "egg", t = "add"
 Output: true

 Example 2:
 Input: s = "foo", t = "bar"
 Output: false

 Example 3:
 Input: s = "paper", t = "title"
 Output: true
 -------------------------------------
 Approach:

 Using 1 map:
 We can define a map which tracks the char-char mappings. If a value is already mapped, it can not be mapped again.

 */
public class _205_IsomorphicStrings {

    public static void main(String[] args) {
        _205_IsomorphicStrings obj = new _205_IsomorphicStrings();
        String s = "foo";
        String t = "bar";
        System.out.println(obj.isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())    //length should be same
            return false;

        Map<Character, Character> map = new HashMap<>();        //map to maintain character to character mapping in s and t
        for(int i=0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map.containsKey(c1)){                           //if c1 present, then check if c2 is same as already mapped
                if(map.get(c1) != c2){                         //return false if different than prev value
                    return false;
                }
            }else{
                if(map.containsValue(c2)){                      //c1 key not present and c2 is already mapped
                    return false;
                }
                map.put(c1,c2);                                 //else add to map
            }
        }
        return true;
    }
}
