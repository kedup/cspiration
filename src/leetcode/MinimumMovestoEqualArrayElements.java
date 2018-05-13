package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MinimumMovestoEqualArrayElements
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 453. Minimum Moves to Equal Array Elements
 */
public class MinimumMovestoEqualArrayElements {
    /**
     * Given a non-empty integer array of size n, find the minimum number of moves required to
     * make all array elements equal, where a move is incrementing n - 1 elements by 1.

     Example:

     Input:
     [1,2,3]

     Output:
     3

     Explanation:
     Only three moves are needed (remember each move increments two elements):

     [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
                  [1,2,2]

     len * (min + k) = sum + k * (len - 1) * 1.
     ==> k = sum - min * len;

     time : O(n)
     space : O(1)


     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        long sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return (int)(sum - min * nums.length);
    }
}
