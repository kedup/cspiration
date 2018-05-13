package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SumofLeftLeaves
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class SumofLeftLeaves {

    /**
     * 404. Sum of Left Leaves
     * Find the sum of all left leaves in a given binary tree.

     Example:

         3
        / \
       9  20
          /  \
         15   7

     There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

     time : O(n);
     space : O(n);
     * @param root
     * @return
     */

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else res += sumOfLeftLeaves(root.left);
        }
        res += sumOfLeftLeaves(root.right);
        return res;
    }
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null) {
                    res += cur.left.val;
                } else queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return res;
    }

}
