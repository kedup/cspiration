package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : DiameterofBinaryTree
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class DiameterofBinaryTree {
    /**
     * 543. Diameter of Binary Tree
     * Given a binary tree, you need to compute the length of the diameter of the tree.
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
     * This path may or may not pass through the root.
     * Example:
     Given a binary tree
         1
        / \
       2   3
      / \
     4   5
     Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

     length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree

     time : O(n)
     space : O(n)
     * @param root
     * @return
     */

    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
