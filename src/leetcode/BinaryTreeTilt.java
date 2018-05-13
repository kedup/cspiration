package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreeTilt
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 563. Binary Tree Tilt
 */
public class BinaryTreeTilt {
    /**
     * Given a binary tree, return the tilt of the whole tree.

     The tilt of a tree node is defined as the absolute difference between the sum of all
     left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

     The tilt of the whole tree is defined as the sum of all nodes' tilt.

     Example:
     Input:
          1
        /   \
       2     3
      / \   / \
     4   5 6   7
     Output: 1
     Explanation:
     Tilt of node 4 : 0
     Tilt of node 5 : 0
     Tilt of node 6 : 0
     Tilt of node 7 : 0
     Tilt of node 2 : |5-4| = 1
     Tilt of node 3 : |7-6| = 1
     Tilt of node 1 : |2+4+5-3-6-7| = 5
     Tilt of binary tree : 1 + 1 + 5 = 7

     time : O(n)
     space : O(n)

     * @param root
     * @return
     */
    int res = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }
}
