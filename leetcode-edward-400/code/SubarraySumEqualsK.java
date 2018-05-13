package leetcode;

import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SubarraySumEqualsK
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SubarraySumEqualsK {
    /**
     * 560. Subarray Sum Equals K
     * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

     Example 1:
     Input:nums = [1,1,1], k = 2
     Output: 2


     * @param nums
     * @param k
     * @return
     */
    // time : O(n^2) space : O(1)
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    // time : O(n) space : O(n);
    public int subarraySum2(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
