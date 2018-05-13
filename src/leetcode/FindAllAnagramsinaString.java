package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindAllAnagramsinaString
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 438. Find All Anagrams in a String
 */
public class FindAllAnagramsinaString {
    /**
     * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

     Strings consists of lowercase English letters only and the length of
     both strings s and p will not be larger than 20,100.

     The order of output does not matter.

     Example 1:

     Input:
     s: "cbaebabacd" p: "abc"

     Output:
     [0, 6]

     Explanation:
     The substring with start index = 0 is "cba", which is an anagram of "abc".
     The substring with start index = 6 is "bac", which is an anagram of "abc".

     0 1 2 3 4 5 6 7 8 9
     c b a e b a b a c d
                   e
             s

     time : O(n)
     space : O(n)


     * @param s
     * @param p
     * @return
     */

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return res;
        int[] chars = new int[26];
        for (char c : p.toCharArray()) {
            chars[c - 'a']++;
        }
        int start = 0, end = 0;
        int count = p.length();
        while (end < s.length()) {
            if (end - start == p.length() && chars[s.charAt(start++) - 'a'] >= 0) {
                count++;
            }
            if (--chars[s.charAt(end++) - 'a'] >= 0) {
                count--;
            }
            if (count == 0) res.add(start);
        }
        return res;
    }
}
