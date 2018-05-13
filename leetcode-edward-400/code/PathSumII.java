package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edward on 28/07/2017.
 */
public class PathSumII {
    /**
     * 113. Path Sum II
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

     For example:
     Given the below binary tree and sum = 22,
           5
          / \
         4   8
        /   / \
       11  13  4
      /  \    / \
     7    2  5   1
     [
     [5,4,11,2],
     [5,8,4,5]
     ]
     time : O(n);
     space : O(n);
     * @param root
     * @param sum
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(list));
            }
        }
        helper(res, list, root.left, sum - root.val);
        helper(res, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
}
