package com.dsalgorithms.coding_platforms.leetcode.medium;

import java.util.Map;
import java.util.HashMap;

/**
 //HINT: First count the bulls and then based on remaining count cows

 Approach:
 1. Maintain a map and count freq of digits in secret

 2. //bulls = digits in the guess that are in the correct position
 So calculate bulls right away in 1 pass and reduce frequency in map when match

 3.  //cows = digits in the guess that are in secret number but are located in wrong position
 So calculate cows in 2nd pass when frequency is >0 and reduce frequency in map

 4. return result
 */
class _299_Bulls_Cows {

    public static void main(String[] args) {
        _299_Bulls_Cows obj = new _299_Bulls_Cows();
        String secret = "1807", guess = "7810";
        System.out.println(obj.getHint(secret, guess));
    }

    public String getHint(String secret, String guess) {

        //both secret and guess should be of same length
        if(secret.length() != guess.length())
            return null;

        //count freq of digits in secret
        Map<Character, Integer> secretMap = new HashMap<>();
        for(int i=0; i<secret.length(); i++){
            char ch = secret.charAt(i);
            if(secretMap.containsKey(ch)){
                secretMap.put(ch, secretMap.get(ch) + 1);
            }else{
                secretMap.put(ch, 1);
            }
        }

        //HINT: First count the bulls and then based on remaining count cows

        //bulls = digits in the guess that are in the correct position
        int bulls = 0;
        for(int i=0; i < guess.length(); i++){
            char ch = guess.charAt(i);
            if(secret.charAt(i) == ch){
                bulls++;
                secretMap.put(ch, secretMap.get(ch) - 1);   //reduce frequency in map
            }
        }

        //cows = digits in the guess that are in secret number but are located in wrong position
        int cows = 0;
        for(int i=0; i < guess.length(); i++){
            char ch = guess.charAt(i);
            if(secret.charAt(i) != ch && secretMap.containsKey(ch) && secretMap.get(ch) > 0){
                cows++;
                secretMap.put(ch, secretMap.get(ch) - 1);   //reduce frequency in map
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bulls + "A" + cows + "B");
        return sb.toString();
    }

    //Time: O(n), Space = O(10) for map as there are 10 numbers
    //We can also maintain freq array for 10 numbers
}
