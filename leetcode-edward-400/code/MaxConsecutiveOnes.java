package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MaxConsecutiveOnes
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 485. Max Consecutive Ones
 */
public class MaxConsecutiveOnes {
    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array.

     Example 1:
     Input: [1,1,0,1,1,1]
     Output: 3
     Explanation: The first two digits or the last three digits are consecutive 1s.
     The maximum number of consecutive 1s is 3.

     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                res = Math.max(res, count);
            } else count = 0;
        }
        return res;
    }
}
