package leetcode;

import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RangeSumQueryMutable
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 307. Range Sum Query - Mutable
 */
public class RangeSumQueryMutable {

    int[] nums;
    int[] tree;
    int n;

    // time : O(n * logn)
    public RangeSumQueryMutable(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    // time : O(logn)
    public void update(int i, int val) {
        if (n == 0) return;
        int diff = val - nums[i];
        nums[i] = val;
        for (int j = i + 1; j <= n; j += j & (-j)) {
            tree[j] += diff;
        }
    }

    // time : O(logn)
    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int sum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }

    /**
     * 解法2
     */
    //private int[] tree;
    //private int[] nums;

    public void NumArray(int[] nums) {
        this.nums = nums;
        int sum;
        int lowbit;
        tree = new int[nums.length + 1];
        for (int i = 1; i < tree.length; i++) {
            sum = 0;
            lowbit = i & (-i);
            for (int j = i; j > i - lowbit; j--) {
                sum = sum + nums[j - 1];
            }
            tree[i] = sum;
        }
    }

    public void update2(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        i++;
        for (; i < tree.length; i += (i & (-i))) {
            tree[i] += diff;
        }
    }

    public int sumRange2(int i, int j) {
        return sum2(j + 1) - sum2(i);
    }

    private int sum2(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }

}
