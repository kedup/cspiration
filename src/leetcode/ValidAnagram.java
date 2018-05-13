package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ValidAnagram
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 242. Valid Anagram
 */
public class ValidAnagram {
    /**
     * For example,
     s = "anagram", t = "nagaram", return true.
     s = "rat", t = "car", return false.

     * @param s
     * @param t
     * @return
     */

    //time : O(nlogn) space : O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    //time : O(n) space : O(1)
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }
}
