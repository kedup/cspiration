package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LongestSubstringwithAtMostKDistinctCharacters
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 340. Longest Substring with At Most K Distinct Characters
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    /**
     * Given a string, find the length of the longest substring T that contains
     * at most k distinct characters.

     For example, Given s = “eceba” and k = 2,

     T is "ece" which its length is 3.

     sliding window

     time : O(n)
     space : O(1)

     * @param s
     * @param k
     * @return
     */

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int res = 0, num = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(j++)] > 0);
                num--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
