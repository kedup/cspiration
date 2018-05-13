package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BalancedBinaryTree
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class BalancedBinaryTree {

    /**
     * 110. Balanced Binary Tree
     * Given a binary tree, determine if it is height-balanced.

     For this problem, a height-balanced binary tree is defined as a binary tree
     in which the depth of the two subtrees of every node never differ by more than 1.
         1  -- 3
        / \
       2   3  -- 1
      / \
     4   5  -- 1

         1
        / \
       2   3  2 --> 3  3 --> 1
      / \
     4   5  -- 2
          \
          9  -- 1

     time : O(n);
     space : O(n);
     * @param root
     * @return
     */

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }
}
