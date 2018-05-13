package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindLeavesofBinaryTree
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 366. Find Leaves of Binary Tree
 */
public class FindLeavesofBinaryTree {
    /**
     * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves,
     * repeat until the tree is empty.

     Example:
     Given binary tree
         1
        / \
       2   3
      / \
     4   5   0
     /
     null   -1
     Returns [4, 5, 3], [2], [1].


     Explanation:
     1. Removing the leaves [4, 5, 3] would result in this tree:

       1
      /
     2
     2. Now removing the leaf [2] would result in this tree:

     1
     3. Now removing the leaf [1] would result in the empty tree:

     []
     Returns [4, 5, 3], [2], [1].

     time : O(n)
     space : O(n)

     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null) return -1;
        int left = helper(res, root.left);
        int right = helper(res, root.right);
        int level = Math.max(left, right) + 1;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }
}
