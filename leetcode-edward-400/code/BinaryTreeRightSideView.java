package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreeRightSideView
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class BinaryTreeRightSideView {

    /**
     * 199. Binary Tree Right Side View
     * given a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.

     For example:
     Given the following binary tree,
        1            <---
      /   \
     2     3         <---
     \     \
     5     4       <---
     You should return [1, 3, 4].

     root 1 res : 0 level : 1

     res : 1, 3, 4

     time : O(n);
     time ; O(n);
     * @param root
     * @return
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(root.val);
        }
        helper(res, root.right, level + 1);
        helper(res, root.left, level + 1);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) res.add(cur.val);
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }
        }
        return res;
    }
}
