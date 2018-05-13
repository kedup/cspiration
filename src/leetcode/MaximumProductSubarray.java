package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MaximumProductSubarray
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class MaximumProductSubarray {
    /**
     * 152. Maximum Product Subarray
     * For example, given the array [2,3,-2,4],
     the contiguous subarray [2,3] has the largest product = 6.

     time : O(n)
     space : O(1)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
