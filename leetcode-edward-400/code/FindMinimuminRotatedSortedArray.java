package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindMinimuminRotatedSortedArray
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class FindMinimuminRotatedSortedArray {
    /**
     * 153. Find Minimum in Rotated Sorted Array
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     4 5 6 7 0 1 2

     4 5 6 0 1 2 3

     2 1

     * time : O(logn)
     * space : O(1);
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] < nums[end]) return nums[start];
        else return nums[end];
    }
}
