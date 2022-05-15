package com.dsalgorithms.books.cracking_the_coding_interview.data_structures.arraystrings;

/**
 1.4 Palindrome Permutation:
 Given a string, write a function to check if it is permutation of a _6_palindrome.

 IMP LOGIC: To be a permutation of a _6_palindrome, a string can have no more than 1 character that occurs odd times.
 */
public class _4_PalindromePermutation {
    public static void main(String[] args) {
        _4_PalindromePermutation obj = new _4_PalindromePermutation();

        String s = "aabbcc   dc";
        boolean flag = obj.isPermutationPalindrome(s);
        System.out.println("String = "+ s+ "\nIs Permutation Palindrome : "+flag);

        flag = obj.isPermPalindrome(s);
        System.out.println("String = "+ s+ "\nIs Permutation Palindrome 1 : "+flag);
    }

    /**
     * Approach 1:
     * 1. Store character frequencies in table
     * 2. Loop through table array, and check no more than 1 characters has odd value.
     * Complexity: Best possible time and algorithms complexity is O(n)
     *
     * Improvement: Instead of constant array, we can also use a single bit (integer) to check if odd/even
     */
    private boolean isPermutationPalindrome(String s) {
        //Assumption - String will contain a-z characters, so defining array length accordingly
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        //Store character frequencies in table
        for(Character ch : s.toCharArray()){
            if(ch != ' '){
                int x = Character.getNumericValue(ch) - Character.getNumericValue('a');
                table[x]++;
            }
        }

        //Loop through table array, and check no more than 1 characters has odd value.
        boolean foundOdd = false;
        for(int i = 0; i < table.length; i++){
            if(table[i] % 2 == 1){
                if(foundOdd){       //if its already true, then return false
                    return false;
                }
                foundOdd = true;    //set true, as atmost 1 character can be odd
            }
        }
        return true;
    }


    /**
     * Normal implementation
     * @param s
     * @return
     */
    private boolean isPermPalindrome(String s){
        int[] charFreq = new int[256];

        //calculate char frequencies
        for(int ch : s.toCharArray()){
            if(ch != 32) {              //skip space char ascii
                charFreq[ch]++;
                System.out.println(ch + " " + ((char) ch) + " " + charFreq[ch]);
            }
        }

        //if no more than 1 odd count, then _6_palindrome permutation possible
        boolean isOdd = false;
        for(int i=0; i < charFreq.length; i++){
            if(charFreq[i]%2 != 0){
                if(isOdd) {
                    return false;
                }
                isOdd = true;
            }
        }
        return true;
    }

}
