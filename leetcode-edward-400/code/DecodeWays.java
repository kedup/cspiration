package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : DecodeWays
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 91. Decode Ways
 */
public class DecodeWays {
    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:

     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26
     Given an encoded message containing digits, determine the total number of ways to decode it.

     For example,
     Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

     The number of ways decoding "12" is 2.


     time : O(n)


     * @param s
     * @return
     */

    // space : O(n)
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= len; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    //space : O(1)
    public int numDecodings2(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int c1 = 1;
        int c2 = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                c1 = 0;
            }
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                c1 = c1 + c2;
                c2 = c1 - c2;
            } else {
                c2 = c1;
            }
        }
        return c1;
    }
}
