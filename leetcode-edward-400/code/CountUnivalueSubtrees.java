package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CountUnivalueSubtrees
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 250. Count Univalue Subtrees
 */
public class CountUnivalueSubtrees {
    /**
     * Given a binary tree, count the number of uni-value subtrees.

     A Uni-value subtree means all nodes of the subtree have the same value.

     For example:
     Given binary tree,
         5
        / \
       1   5
      / \   \
     5   5   5
     return 4.

     root = 5 res = 2
     root = 1
     root = 5 res = 3
     root = 5 res = 4

     time : O(n)
     space : O(n)


     */

    int res;

    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    public boolean helper(TreeNode root) {
        if (root == null) return true;

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            res++;
            return true;
        }
        return false;
    }

}
