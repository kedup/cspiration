package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PatchingArray
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 330. Patching Array
 */
public class PatchingArray {
    /**
     * Given a sorted positive integer array nums and an integer n,
     * add/patch elements to the array such that any number in range [1, n] inclusive can be formed
     * by the sum of some elements in the array. Return the minimum number of patches required.

     Example 1:
     nums = [1, 3], n = 6
     Return 1.

     Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
     Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
     Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
     So we only need 1 patch.

     Example 2:
     nums = [1, 5, 10], n = 20
     Return 2.
     The two patches can be [2, 4].

     Example 3:
     nums = [1, 2, 2], n = 5
     Return 0.

     [1, 2, 5, 13, 24]

     miss: 表示[0,n]之间最小的不能表示的值
     num <= miss  =>  [0, miss+num)

     nums = [1, 2, 5, 13, 24], n = 50

     miss = 1

     1 + 2 + 4 + 5 = 12

     1 : miss = 2
     2 : miss = 4
     5 : miss = 8 res = 1
     5 : miss = 13
     13 : miss = 26
     24 : miss = 50 res = 2

     time : O(n)
     space : O(1)

     * @param nums
     * @param n
     * @return
     */

    public int minPatches(int[] nums, int n) {
        int i = 0, res = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                res++;
            }
        }
        return res;
    }
}
