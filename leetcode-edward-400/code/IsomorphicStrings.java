package leetcode;

import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : IsomorphicStrings
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 205. Isomorphic Strings
 */
public class IsomorphicStrings {
    /**
     * For example,
     Given "egg", "add", return true.

     Given "foo", "bar", return false.

     Given "paper", "title", return true.

     egg add

     * @param s
     * @param t
     * @return
     */
    // time : O(n) space : O(n)
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return true;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b)) continue;
                else return false;
            } else {
                if (!map.containsValue(b)) {
                    map.put(a, b);
                } else return false;
            }
        }
        return true;
    }


    // time : O(n) space : O(1)
    public boolean isIsomorphic2(String s, String t) {
        int[] sChars = new int[256];
        int[] tChars = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (sChars[s.charAt(i)] != tChars[t.charAt(i)]) {
                return false;
            } else {
                sChars[s.charAt(i)] = tChars[t.charAt(i)] = t.charAt(i);
            }
        }
        return true;
    }
}
