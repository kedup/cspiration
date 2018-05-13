package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SearchInsertPosition
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SearchInsertPosition {

    /**
     * 35. Search Insert Position
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

     You may assume no duplicates in the array.

     Here are few examples.
     [1,3,5,6], 5 → 2
     [1,3,5,6], 2 → 1
     [1,3,5,6], 7 → 4
     [1,3,5,6], 0 → 0

     __target___target

     time : O(logn);
     space : O(1);
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) end = mid;
            else start = mid;
        }
        if (target <= nums[start]) {
            return start;
        } else if (target <= nums[end]) {
            return end;
        } else {
            return end + 1;
        }
    }
}
