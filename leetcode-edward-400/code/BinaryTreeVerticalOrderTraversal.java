package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreeVerticalOrderTraversal
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 314. Binary Tree Vertical Order Traversal
 */
public class BinaryTreeVerticalOrderTraversal {
    /**
     *Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

     If two nodes are in the same row and column, the order should be from left to right.

     Examples:

     Given binary tree [3,9,20,null,null,15,7],
         3
        / \
       9  20
          / \
        15  7

              |
      . _ * _ * _ 0 _ . _ *
     -2  -1   0   1   2   3

     return its vertical order traversal as:
     [
     [9],
     [3,15],
     [20],
     [7]
     ]
     Given binary tree [3,9,8,4,0,1,7],
          3
         / \
       9    8
      / \  / \
     4  0 1   7
     -2  0   2

     return its vertical order traversal as:
     [
     [4],
     [9],
     [3,0,1],
     [8],
     [7]
     ]

     1, dfs max min
     2, bfs

     time : O(n)
     space : O(n)


     */
    private int min = 0;
    private int max = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, 0);
        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<>());
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        index.offer(-min);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int idx = index.poll();
            res.get(idx).add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                index.offer(idx - 1);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                index.offer(idx + 1);
            }
        }
        return res;
    }

    private void helper(TreeNode root, int idx) {
        if (root == null) return;
        min = Math.min(min, idx);
        max = Math.max(max, idx);
        helper(root.left, idx - 1);
        helper(root.right, idx + 1);
    }
}
