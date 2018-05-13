package leetcode;

import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PerfectSquares
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 279. Perfect Squares
 */
public class PerfectSquares {

    /**
     * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
     * which sum to n.

     For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

     time : O(n * sqrt(n))
     space: O(n)

     * @param n
     * @return
     */

    public int numSquares(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
        }
        return res[n];
    }
}
