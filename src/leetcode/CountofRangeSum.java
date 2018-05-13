package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CountofRangeSum
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 327. Count of Range Sum
 */
public class CountofRangeSum {
    /**
     * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
     Range sum S(i, j) is defined as the sum of the elements in nums
     between indices i and j (i ≤ j), inclusive.

     Note:
     A naive algorithm of O(n2) is trivial. You MUST do better than that.

     Example:
     Given nums = [-2, 5, -1], lower = -2, upper = 2,
     Return 3.
     The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.

     1 2 3
     1 3 6 .. lower = 1 upper = 3

     sum = 6     3 - 5
     treeMap :  1 3
     Map : (3,1)

     TreeMap<Key, Value>
     subMap

     * @param nums
     * @param lower
     * @param upper
     * @return
     */

    // time : O(n^2) 不确定 space : O(n)
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        TreeMap<Long, Long> treeMap = new TreeMap<>();
        treeMap.put((long)0, (long)1);
        long sum = 0;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long from = sum - upper;
            long to = sum - lower;
            Map<Long, Long> sub = treeMap.subMap(from, true, to, true);
            for (Long value : sub.values()) {
                count += value;
            }
            treeMap.put(sum, treeMap.getOrDefault(sum, (long)0) + 1);
        }
        return (int)count;
    }

    // time : O(nlogn) space : O(n)
    public int countRangeSum2(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        return helper(sum, new long[sum.length], 0, sum.length - 1, lower, upper);
    }

    /**
     rangeEnd是第一个满足 sums[rangeEnd] - sums[i] > upper 的下标

     rangeStart是第一个满足 sums[rangeStart] - sums[i] >= lower 的下标

     [lower, upper]之间的区间的个数是rangeEnd - rangeStart


     遍历前半段 匹配后半段
     [1,3]  [2,4]


     * @param sum
     * @param helper
     * @param low
     * @param high
     * @param lower
     * @param upper
     * @return
     */

    private int helper(long[] sum, long[] helper, int low, int high, long lower, long upper) {
        if (low >= high) {
            return 0;
        }

        int mid = (high + 1 - low) / 2 + low;
        int count = helper(sum, helper, low, mid - 1, lower, upper)
                + helper(sum, helper, mid, high, lower, upper);

        int rangeStart = mid, rangeEnd = mid;
        for(int i = low; i < mid; i++) {
            while(rangeStart <= high && sum[rangeStart] - sum[i] < lower)
                rangeStart++;
            while(rangeEnd <= high && sum[rangeEnd] - sum[i] <= upper)
                rangeEnd++;

            count += rangeEnd - rangeStart;
        }

        merge(sum, helper, low, mid, high);
        return count;
    }

    private void merge(long[] sum, long[] helper, int low, int mid, int high) {
        int left = low, right = mid, idx = low;

        while(left < mid && right <= high) {
            if (sum[left] <= sum[right])
                helper[idx++] = sum[left++];
            else
                helper[idx++] = sum[right++];
        }

        while(left < mid)
            helper[idx++] = sum[left++];
        while(right <= high)
            helper[idx++] = sum[right++];

        System.arraycopy(helper, low, sum, low, high + 1 - low);
    }
}
