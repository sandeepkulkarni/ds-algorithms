package com.dsalgorithms.coding_platforms.leetcode.medium;

import java.util.*;

/**

 */
public class _692_TopK_FrequentWords {

    public static void main(String[] args) {
        _692_TopK_FrequentWords obj = new _692_TopK_FrequentWords();
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> result = obj.topKFrequent(words, k);
        System.out.println(Arrays.toString(result.toArray()));

    }

    public List<String> topKFrequent(String[] words, int k) {

        //Count frequency of words
        Map<String, Integer> wordCount = new HashMap<>();
        for(String s : words){
            if(wordCount.containsKey(s)){
                wordCount.put(s, wordCount.get(s) + 1);
            }else{
                wordCount.put(s, 1);
            }
        }

        //print map
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        //Priority Queue
        //if freq for both words same then sort lexicographical (a - b) else (b - a) as we want descending
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ?
                            a.getKey().compareTo(b.getKey()) :
                                b.getValue() - a.getValue()
        );

        pq.addAll(wordCount.entrySet());        //add all entries to pq

        List<String> result = new ArrayList<>();
        for (int i=0; i < k; i++ ){
            result.add(pq.poll().getKey());           //add top K to result
        }
        return result;
    }
    //Time: O(n * log(n)), Space: O(n)
}
