package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : HouseRobber
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 198. House Robber
 */
public class HouseRobber {
    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, the only constraint stopping you from robbing
     * each of them is that adjacent houses have security system connected and it will automatically contact
     * the police if two adjacent houses were broken into on the same night.
     *
     [1, 3, 2, 4, 1]
          No  Yes
     1 :  0    1
     3 :  1    3
     2 :  3    3

     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int num : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = num + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}
