package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MinimumWindowSubstring
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 76. Minimum Window Substring
 */
public class MinimumWindowSubstring {
    /**
     * sliding window
     * Given a string S and a string T, find the minimum window in S which will contain all the characters
     * in T in complexity O(n).

     For example,
     S = "ADOBECODEBANC"
     T = "ABC"
     Minimum window is "BANC".

     Note:
     If there is no such window in S that covers all characters in T, return the empty string "".

     If there are multiple such windows, you are guaranteed that there will always be only one unique
     minimum window in S.

     test case:
     S = "ADOBECODEBANC"
     T = "ABC"

     ADOBEC
     DOBECODEBA
     OBECODEBA
     BECODEBA
     ECODEBA
     CODEBA
     ODEBANC
     DEBANC
     EBANC
     BANC

            A B C D E F G H    O
     count: 0 0 0 -1-1         -1
            0 1 2 3 4 5 6 7 ...

     A D O B E C O D E B A N C
               i
     CODEBA
     total = 1

     time : O(n)
     space : O(1)

     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int from = 0;
        int total = t.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0) total--;
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++cnt[s.charAt(j++)] > 0) total++;
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }
}
