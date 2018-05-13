package leetcode;

import java.util.Random;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ShuffleanArray
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ShuffleanArray {
    /**
     * 384. Shuffle an Array
     * // Init an array with set 1, 2, and 3.
     int[] nums = {1,2,3};
     Solution solution = new Solution(nums);

     // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
     solution.shuffle();

     // Resets the array back to its original configuration [1,2,3].
     solution.reset();

     // Returns the random shuffling of array [1,2,3].
     solution.shuffle();

     time : O(n)
     * @param nums
     */

    private int[] nums;
    private Random rmd;

    // 题中第构造函数时Solution
    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        rmd = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) return null;
        int[] clone = nums.clone();
        for (int i = 1; i < clone.length; i++) {
            int random = rmd.nextInt(i + 1);
            swap(clone, i, random);
        }
        return clone;
    }
    private void swap(int[] clone, int i, int j) {
        int temp = clone[i];
        clone[i] = clone[j];
        clone[j] = temp;
    }
}
