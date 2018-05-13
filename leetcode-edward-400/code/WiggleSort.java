package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : WiggleSort
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 280. Wiggle Sort
 */
public class WiggleSort {
    /**
     * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

     For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

     time : O(n)
     space : O(1)


     * @param nums
     */
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                int temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
