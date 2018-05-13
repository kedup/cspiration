package leetcode;

import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RemoveDuplicateLetters
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 316. Remove Duplicate Letters
 */
public class RemoveDuplicateLetters {
    /**
     * Given a string which contains only lowercase letters, remove duplicate letters
     * so that every letter appear once and only once. You must make sure your result is the smallest
     * in lexicographical order among all possible results.

     Example:
     Given "bcabc"
     Return "abc"

     Given "cbacdcbc"
     Return "acdb"

     c b a c d c b c
     0 1 2 3 4 5 6 7

     map :



     cba start = 3 end = 4 a
     cd start = 4 end = 4 ac
     d start = 5 end = 6 acd
     cb start = 7 end    acdb

     time : O(n)
     space : O(n)


     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        char[] res = new char[map.size()];
        int start = 0, end = findMinLastPos(map);
        for (int i = 0; i < res.length; i++) {
            char minChar = 'z' + 1;
            for (int k = start; k <= end; k++) {
                if (map.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    start = k + 1;
                }
            }
            res[i] = minChar;
            map.remove(minChar);
            if (s.charAt(end) == minChar) {
                end = findMinLastPos(map);
            }
        }
        return new String(res);
    }

    public int findMinLastPos(HashMap<Character, Integer> map) {
        int res = Integer.MAX_VALUE;
        for (int num : map.values()) {
            res = Math.min(res, num);
        }
        return res;
    }
}
