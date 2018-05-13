package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SingleNumberII
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 137. Single Number II
 */
public class SingleNumberII {
    /**
     * Given an array of integers, every element appears three times except for one, which appears exactly once.
     * Find that single one

     0 -> 1 -> 2 -> 0
     00 -> 01 -> 10 -> 00
     00 -> 10 -> 01 -> 00

     ones twos
      0     0
     0 -> 1 0 -> 0
     1 -> 0 0 -> 1
     0 -> 0 1 -> 0

     1, 存入ones里
     2，清空ones 存入twos
     3，twos进行清空

     time : O(n)
     space : O(1)


     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
