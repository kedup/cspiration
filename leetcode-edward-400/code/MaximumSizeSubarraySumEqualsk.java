package leetcode;

import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MaximumSizeSubarraySumEqualsk
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 325. Maximum Size Subarray Sum Equals k
 */
public class MaximumSizeSubarraySumEqualsk {
    /**
     * Example 1:
     Given nums = [1, -1, 5, -2, 3], k = 3,
     return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

     Example 2:
     Given nums = [-2, -1, 2, 1], k = 1,
     return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

     [1, -1, 5, -2, 3]  k = 3

     1, 0, 5, 3, 6  k = 3

     time : O(n)
     space : O(n)

     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                res = Math.max(res, i - map.get(nums[i] - k));
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
