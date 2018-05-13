package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LongestSubstringWithoutRepeatingCharacters
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 3. Longest Substring Without Repeating Characters
     * Examples:

     Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.

     Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
     "pwke" is a subsequence and not a substring.


     time : O(n)
     space : O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }
}
