package leetcode;

import java.util.HashSet;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PalindromePermutation
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class PalindromePermutation {
    /**
     * 266. Palindrome Permutation
     * Given a string, determine if a permutation of the string could form a palindrome.

     For example,
     "code" -> False, "aab" -> True, "carerac" -> True.

     time : O(n)
     * @param s
     * @return
     */

    //space : O(n)
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    //space : O(1)
    public boolean canPermutePalindrome2(String s) {
        char[] count = new char[256];
        int res = 0;
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) res++;
        }
        return res <= 1;
    }
}
