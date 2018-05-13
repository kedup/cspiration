package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PalindromicSubstrings
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class PalindromicSubstrings {
    /**
     * 647. Palindromic Substrings
     * Example 1:
     Input: "abc"
     Output: 3
     Explanation: Three palindromic strings: "a", "b", "c".
     Example 2:
     Input: "aaa"
     Output: 6
     Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

     time : O(n^2);

     * @param s
     * @return
     */

    // space : O(n^2);
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) res++;
            }
        }
        return res;
    }

    int count = 0;

    // space : O(1)
    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return count;
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
