package leetcode;


/**
 * Created by Edward on 28/07/2017.
 */
public class MaximumDepthofBinaryTree {
    /**
     * 104. Maximum Depth of Binary Tree
     * Given a binary tree, find its maximum depth.

     The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

     time : O(n);
     space : O(n);
     * @param root
     * @return
     */

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth2(root.left) + 1;
        int r = maxDepth2(root.right) + 1;
        return Math.max(l, r);
    }
}
