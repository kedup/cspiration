package leetcode;

/**
 * Created by Edward on 25/07/2017.
 */
public class RemoveDuplicatesfromSortedArray {
    /**
     * 26. Remove Duplicates from Sorted Array
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

     Do not allocate extra space for another array, you must do this in place with constant memory.

     For example,
     Given input array nums = [1,1,2],

     Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

     case : [1,1,2,2,3,4,5,6]
             1,2,3,4,5,6
                 c
                     i
     result : [1,2,3,4,5,6]

     time : O(n);
     space : O(1);

     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
