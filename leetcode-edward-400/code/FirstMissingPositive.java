package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FirstMissingPositive
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 41. First Missing Positive
 */
public class FirstMissingPositive {
    /**
     * Given an unsorted integer array, find the first missing positive integer.

     For example,
     Given [1,2,0] return 3,
     and [3,4,-1,1] return 2.

     Your algorithm should run in O(n) time and uses constant space.

     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
