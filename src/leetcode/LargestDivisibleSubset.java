package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LargestDivisibleSubset
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 368. Largest Divisible Subset
 */
public class LargestDivisibleSubset {
    /**
     * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj)
     * of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

     If there are multiple solutions, return any subset is fine.

     Example 1:

     nums: [1,2,3]

     Result: [1,2] (of course, [1,3] will also be ok)
     Example 2:

     nums: [1,2,4,8]

     Result: [1,2,4,8]

     1 2 4 6 8

            1 2 4 6 8
     pre : -1 0 1 1 2
     count: 1 2 3 3 4

     Arrays.sort()
     count[]
     pre[] : index[]

     int index(4) max(4)

     a % b == 0
     b % c == 0
     a % c == 0

     pre

     time : O(n^2)
     space : O(n)

     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);
        int[] count = new int[nums.length];
        int[] pre = new int[nums.length];
        int max = 0, index = -1;

        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
                if (count[i] > max) {
                    max = count[i];
                    index = i;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
