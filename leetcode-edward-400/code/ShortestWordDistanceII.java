package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ShortestWordDistanceII
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class ShortestWordDistanceII {

    /**
     * 244. Shortest Word Distance II
     *This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

     Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

     For example,
     Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

     Given word1 = “coding”, word2 = “practice”, return 3.
     Given word1 = "makes", word2 = "coding", return 1.


     space : O(n);
     * @param words
     */

    //ShortestWordDistanceII 这个题在leetcode中构造函数是 WordDistance

    private HashMap<String, List<Integer>> map;


    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    //time : O(n * m)
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for (Integer num1 : l1) {
            for (Integer num2 : l2) {
                res = Math.min(res, Math.abs(num1 - num2));
            }
        }
        return res;
    }

    //time : O(n + m)
    public int shortest2(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) < l2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

}
