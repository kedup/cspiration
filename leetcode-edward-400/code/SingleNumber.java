package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SingleNumber
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 136. Single Number
 */
public class SingleNumber {
    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     *
     * ^ : 异或 : 相同为0，不同为1
     * 1 1 : 0
     * 0 0 : 0
     * 1 0 : 1
     * 0 1 : 1
     *
     * time : O(n) space : O(1)
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
