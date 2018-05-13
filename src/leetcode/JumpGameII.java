package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : JumpGameII
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class JumpGameII {
    /**
     * 45. Jump Game II
     * For example:
     Given array A = [2,3,1,1,4]

     The minimum number of jumps to reach the last index is 2. (Jump 1 res from index 0 to 1,
     then 3 ress to the last index.)

     * @param nums
     * @return
     */

    //time : O(n) space : O(1)
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int res = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxNext = Math.max(maxNext, i + nums[i]);
            if (i == curMaxArea) {
                res++;
                curMaxArea = maxNext;
            }
        }
        return res;
    }

    /**
     [2,3,1,1,4]

     level = 2
     cur = 2
     max = 4
     i = 1

     * @param nums
     * @return
     */
    // time : O(n)  space : O(1)
    public int jump2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int level = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        int i = 0;
        while (curMaxArea - i + 1 > 0) {
            level++;
            for (; i <= curMaxArea; i++) {
                maxNext = Math.max(maxNext, nums[i] + i);
                if (maxNext >= nums.length - 1) {
                    return level;
                }
            }
            curMaxArea = maxNext;
        }
        return 0;
    }
}
