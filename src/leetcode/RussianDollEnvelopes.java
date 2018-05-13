package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RussianDollEnvelopes
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 354. Russian Doll Envelopes
 */
public class RussianDollEnvelopes {
    /**
     * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
     * One envelope can fit into another if and only if both the width and height of one envelope
     * is greater than the width and height of the other envelope.

     What is the maximum number of envelopes can you Russian doll? (put one inside other)

     Example:
     Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll
     is 3 ([2,3] => [5,4] => [6,7]).

     排序
     weight ->
     height <-

     [6 4][6 7]

     [2, 3] -> [5, 4] -> [6, 7] -> [6, 4]

     3 4 7 4 -> 3 4 7

     time : O(nlogn)
     space : O(n)

     * @param envelopes
     * @return
     */

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int[] envelope : envelopes) {
            int i = binarySearch(dp, 0, res, envelope[1]);
            dp[i] = envelope[1];
            if (i == res) {
                res++;
            }
        }
        return res;
    }

    public int binarySearch(int[] dp, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (dp[start] >= target) return start;
        return end;
    }
}
