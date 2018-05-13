package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ThreeSumSmaller
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 259. 3Sum Smaller
 */
public class ThreeSumSmaller {
    /**
     * nums[i] + nums[j] + nums[k] < target.
     * For example, given nums = [-2, 0, 1, 3], and target = 2.

     Return 2. Because there are two triplets which sums are less than 2:

     [-2, 0, 1]
     [-2, 0, 3]

     time : O(n^2);
     space : O(1);


     nums = [-2, 0, 1, 3], and target = 2.

     * @param nums
     * @param target
     * @return
     */

    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    res += right - left;
                    left++;
                } else right--;
            }
        }
        return res;
    }
}
