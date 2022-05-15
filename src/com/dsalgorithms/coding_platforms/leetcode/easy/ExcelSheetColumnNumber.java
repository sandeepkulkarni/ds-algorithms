package com.dsalgorithms.coding_platforms.leetcode.easy;

/**
 171. Excel Sheet Column Number
 https://leetcode.com/problems/excel-sheet-column-number/

 Related to question Excel Sheet Column Title (https://leetcode.com/problems/excel-sheet-column-title/)

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:
 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 -----------------------------------------------------------------------------------------------------------------------
Approach:
 Example if the input is 'CDA', and the values are 3,4,1
 the index of each char in the string in reverse order plus one is 2, 1, 0

 Formula:
 result = result * 26 + (subtract by 'A' to get value of character between 0-26)

 so in this case.

 result = 3 * (26^2) + 4 * (26^1) + 1 * (26^0) = 2133

 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int colNo = 0;
        for(int i=0; i < s.length(); i++){
            int charVal = (s.charAt(i) - 'A') + 1;
            colNo = colNo * 26 + charVal;
        }
        return colNo;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber excel = new ExcelSheetColumnNumber();
        String col = "CDA";
        int colNo = excel.titleToNumber(col);
        System.out.println("Column: "+ col + " value: "+ colNo);
    }
}
