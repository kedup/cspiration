package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ContainsDuplicate
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 217. Contains Duplicate
 */
public class ContainsDuplicate {

    // time : O(n) space : O(n)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    // time : O(nlogn) space : O(1)
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}
