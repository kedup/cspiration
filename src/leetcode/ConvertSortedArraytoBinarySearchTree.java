package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ConvertSortedArraytoBinarySearchTree
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ConvertSortedArraytoBinarySearchTree {
    /**
     * 108. Convert Sorted Array to Binary Search Tree

     [1,2,3,4,5]

     time : O(n);
     space : O(n);
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {  // space : O(logn);
        if (left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}
