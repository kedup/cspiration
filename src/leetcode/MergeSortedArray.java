package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MergeSortedArray
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 88. Merge Sorted Array
 */
public class MergeSortedArray {
    /**

     time : O(m + n)
     space : O(1)

     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
