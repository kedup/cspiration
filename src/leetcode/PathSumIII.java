package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PathSumIII
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 437. Path Sum III
 */
public class PathSumIII {
    /**
     * You are given a binary tree in which each node contains an integer value.

     Find the number of paths that sum to a given value.

     The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

     The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

     Example:

     root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

           10
          /  \
         5   -3
        / \    \
       3   2   11
      / \   \
     3  -2   1

     Return 3. The paths that sum to 8 are:

     1.  5 -> 3
     2.  5 -> 2 -> 1
     3. -3 -> 11

     1, DFS
     2, DFS + Memoization : HashMap<Integer, Integer>  <curSum, Num>

     10 + -3 + 11 = 18   -3 + 11 = 8
     (10,1) (7,1) 18 - 8 = 10 (a,b,c) = x  (d,e) = 8  x = curSum - 8

     * @param root
     * @param sum
     * @return
     */

    // time : O(n ^ 2) space : O(n)
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode root, int sum) {
        int res = 0;
        if (root == null) return res;
        if (sum == root.val) res++;
        res += helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
        return res;
    }

    // time : O(n) space : O(n)
    public int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    private int helper(TreeNode root, int curSum, int sum, HashMap<Integer, Integer> map) {
        if (root == null) return 0;
        curSum += root.val;
        int res = map.getOrDefault(curSum - sum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        res += helper(root.left, curSum, sum, map) + helper(root.right, curSum, sum, map);
        map.put(curSum, map.get(curSum) - 1);
        return res;
    }
}
