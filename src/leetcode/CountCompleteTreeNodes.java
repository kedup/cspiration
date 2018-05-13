package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CountCompleteTreeNodes
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 222. Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {

    /**
     * Given a complete binary tree, count the number of nodes.

     Definition of a complete binary tree from Wikipedia:
     In a complete binary tree every level, except possibly the last, is completely filled, and all nodes
     in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

           3
         /   \
        9     20
      /  \   /  \
     15   7 1

     2^h - 1

     time : O(logn * logn)
     space : O(n) / O(logn) 不确定

     * @param root
     * @return
     */

    public int countNodes(TreeNode root) {
        // int left = helper(root, true);
        // int right = helper(root, false);
        int left = leftDepth(root);
        int right = rightDepth(root);

        if (left == right) {
            return (1 << left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftDepth(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.left;
            res++;
        }
        return res;
    }

    private int rightDepth(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.right;
            res++;
        }
        return res;
    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        return isLeft ? helper(root.left, isLeft) + 1: helper(root.right, isLeft) + 1;
    }

    public int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null)
            return (1 << height) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
