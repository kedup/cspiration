package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SubstringwithConcatenationofAllWords
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 30. Substring with Concatenation of All Words
 */
public class SubstringwithConcatenationofAllWords {
    /**
     * You are given a string, s, and a list of words, words, that are all of the same length.
     * Find all starting indices of substring(s) in s that is a concatenation of each word
     * in words exactly once and without any intervening characters.

     For example, given:
     s: "barfoothefoobarman"
     words: ["foo", "bar"]

     You should return the indices: [0,9].
     (order does not matter).

     time : O(n ^ 2)
     space : O(n)

     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int n = words.length;
        int m = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();

        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i <= s.length() - n * m; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n;
            int j = i;
            while (k > 0) {
                String str = s.substring(j, j + m);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                k--;
                j += m;
            }
            if (k == 0) res.add(i);
        }
        return res;
    }
}
