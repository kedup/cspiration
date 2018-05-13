package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : WordPatternII
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 291. Word Pattern II
 */
public class WordPatternII {
    /**
     * Given a pattern and a string str, find if str follows the same pattern.

     Here follow means a full match, such that there is a bijection
     between a letter in pattern and a non-empty substring in str.

     Examples:
     pattern = "abab", str = "redblueredblue" should return true.
     pattern = "aaaa", str = "asdasdasdasd" should return true.
     pattern = "aabb", str = "xyzabcxzyabc" should return false.


     pattern = "abab", str = "redblueredblue" "redres


     time : O(2^n) 不确定
     space : O(n)

     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        return isMatch(str, 0, pattern, 0, map, set);
    }

    private boolean isMatch(String str, int i, String pat, int j, HashMap<Character, String> map, HashSet<String> set) {
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;

        char c = pat.charAt(j);
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (!str.startsWith(s, i)) {
                return false;
            }
            return isMatch(str, i + s.length(), pat, j + 1, map, set);
        }

        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);
            if (set.contains(p)) {
                continue;
            }
            map.put(c, p);
            set.add(p);
            if (isMatch(str, k + 1, pat, j + 1, map, set)) {
                return true;
            }
            map.remove(c);
            set.remove(p);
        }
        return false;
    }
}
