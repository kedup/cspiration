package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : HouseRobberIII
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class HouseRobberIII {
    /**
     * 337. House Robber III
     * Example 1:
       3  red
      / \
     2   3
      \   \
       3   1  red
     Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     Example 2:
         3
        / \
       4   5  red
      / \   \
     1   3   1
     Maximum amount of money the thief can rob = 4 + 5 = 9.

     time : O(n)
     space : O(n)
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}
