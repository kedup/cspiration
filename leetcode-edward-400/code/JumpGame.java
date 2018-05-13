package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : JumpGame
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class JumpGame {
    /**
     * 55. Jump Game
     * For example:
     A = [2,3,1,1,4], return true.

     A = [3,2,1,0,4], return false.

     time : O(n)
     space : O(1)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
