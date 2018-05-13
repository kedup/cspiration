package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MissingNumber
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 268. Missing Number
 */
public class MissingNumber {
    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

     For example,
     Given nums = [0, 1, 3] return 2.

     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */

    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        int expectedSum = (nums.length + 1) / 2 * nums.length;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

}
