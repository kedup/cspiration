package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : IncreasingTripletSubsequence
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 334. Increasing Triplet Subsequence
 */
public class IncreasingTripletSubsequence {
    /**
     * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

     Formally the function should:
     Return true if there exists i, j, k
     such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
     Your algorithm should run in O(n) time complexity and O(1) space complexity.

     Examples:
     Given [1, 2, 3, 4, 5],
     return true.

     Given [5, 4, 3, 2, 1],
     return false.

     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, sedMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) min = num;
            else if (num < sedMin) sedMin = num;
            else if (num > sedMin) return true;
        }
        return false;
    }
}
