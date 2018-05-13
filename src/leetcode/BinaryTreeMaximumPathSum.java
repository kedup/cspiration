package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreeMaximumPathSum
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 124. Binary Tree Maximum Path Sum
 */
public class BinaryTreeMaximumPathSum {
    /**
     * Given a binary tree, find the maximum path sum.

     For this problem, a path is defined as any sequence of nodes from some starting node to any node
     in the tree along the parent-child connections. The path must contain at least one node and does not
     need to go through the root.

     For example:
     Given the below binary tree,

       1
      / \
     2   3
     Return 6.

          3
         / \
        9  20
      /  \
     15   7


     time : O(n)
     space : O(n)

     */

    int res;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
