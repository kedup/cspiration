package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     * 46. Permutations
     * Given a collection of distinct numbers, return all possible permutations.

     For example,
     [1,2,3] have the following permutations:
     [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
     ]

     time : O(n!)
     space : O(n);

     reference : http://www.1point3acres.com/bbs/thread-117602-1-1.html

     The number of recursive calls, T(n) satisfies the recurrence T(n) = T(n - 1) + T(n - 2) + ... + T(1) + T(0),
     which solves to T(n) = O(2^n). Since we spend O(n) time within a call, the time complexity is O(n2^n);

     * @param nums
     * @return
     */
    // time : O(n! * n) space : O(n);
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;  // O(n)
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }

    // time : O(n!) space : O(n);
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper2(res, 0, nums);
        return res;
    }
    public static void helper2(List<List<Integer>> res, int start, int[] nums) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            helper2(res, start + 1, nums);
            swap(nums, start, i);
        }
    }
    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
