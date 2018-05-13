package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindPeakElement
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class FindPeakElement {

    /**
     * 162. Find Peak Element
     * A peak element is an element that is greater than its neighbors.

     Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

     The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

     You may imagine that num[-1] = num[n] = -∞.

     For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.


     1 2 3 1

     1 2 3 2 1

     time : O(logn);
     space : O(1);
     * @param nums
     * @return
     */

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] > nums[end]) return start;
        return end;
    }
}
