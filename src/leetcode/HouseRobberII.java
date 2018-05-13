package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : HouseRobberII
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 213. House Robber II
 */
public class HouseRobberII {
    /**
     * time : O(n)
     * space : O(1)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int lo, int hi) {
        int prevNo = 0;
        int prevYes = 0;
        for (int i = lo; i <= hi; i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = nums[i] + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}
