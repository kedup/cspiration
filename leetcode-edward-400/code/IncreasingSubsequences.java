package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : IncreasingSubsequences
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class IncreasingSubsequences {
    /**
     * 491. Increasing Subsequences
     * Given an integer array, your task is to find all the different possible increasing
     * subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

     Example:
     Input: [4, 6, 7, 7]
     Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]


     time : O(2^n);
     space : O(n);
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length == 0) return new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        List ret = new ArrayList(res);
        return ret;
    }

    public void helper(HashSet<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                helper(res, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
