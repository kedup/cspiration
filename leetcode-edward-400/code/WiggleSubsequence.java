package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : WiggleSubsequence
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 376. Wiggle Subsequence
 */
public class WiggleSubsequence {

    /**
     * Examples:
     Input: [1,7,4,9,2,5]
     Output: 6
     The entire sequence is a wiggle sequence.

     Input: [1,17,5,10,13,15,10,5,16,8]
     Output: 7
     There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

     Input: [1,2,3,4,5,6,7,8,9]
     Output: 2

     dp up[] down[]

     Input: [1,7,4,9,2,5]

     up[1,2,2]
     down[1,1,3]

     time : O(n)
     space : O(n) / O(1)

     * @param nums
     * @return
     */

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[ i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }

    public int wiggleMaxLength2(int[] nums) {
        if (nums.length == 0) return 0;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
