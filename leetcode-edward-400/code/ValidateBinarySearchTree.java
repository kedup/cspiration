package leetcode;

/**
 * Created by Edward on 24/07/2017.
 */
public class ValidateBinarySearchTree {

    /**
     * 98. Validate Binary Search Tree
     * Given a binary tree, determine if it is a valid binary search tree (BST).

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than the node's key.
     The right subtree of a node contains only nodes with keys greater than the node's key.
     Both the left and right subtrees must also be binary search trees.

     time : O(n)
     space : O(n)
     * @param root
     * @return
     */

    public static boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        return helper(root, null, null);
    }

    public static boolean helper(TreeNode root, Integer min, Integer max) {

        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
