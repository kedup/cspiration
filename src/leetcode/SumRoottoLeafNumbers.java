package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SumRoottoLeafNumbers
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 129. Sum Root to Leaf Numbers
 */
public class SumRoottoLeafNumbers {
    /**
     * For example,

       1
      / \
     2   3
     The root-to-leaf path 1->2 represents the number 12.
     The root-to-leaf path 1->3 represents the number 13.

     Return the sum = 12 + 13 = 25.

     time : O(n)
     space : O(n)

     * @param root
     * @return
     */

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int num) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        return helper(root.left, num * 10 + root.val) +
                helper(root.right, num * 10 + root.val);
    }
}
