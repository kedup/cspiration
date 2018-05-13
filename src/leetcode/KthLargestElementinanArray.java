package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : KthLargestElementinanArray
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 215. Kth Largest Element in an Array
 */

public class KthLargestElementinanArray {

    // time : O(n) space : O(1)

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    /**
     *   3,2,1,5,6,4  k = 3
     *   0 1 2 3 4 5
     pivot : 3  [3, 2, 1, 5, 6, 4]
     [3, 4, 6, 5, 1, 2]   3

     pivot : 5  [5, 4, 6, 3, 1, 2]
     [5, 6, 4, 3, 1, 2]   1

     pivot : 4  [6, 5, 4, 3, 1, 2]
     [6, 5, 4, 3, 1, 2]   2
     */

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * time : O(nlogk)
     * space : O(n)
     *
     * @param nums
     * @param k
     * @return
     */


    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
