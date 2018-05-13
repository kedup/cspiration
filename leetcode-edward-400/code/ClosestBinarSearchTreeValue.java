package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ClosestBinarSearchTreeValue
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 270. Closest Binary Search Tree Value
 */
public class ClosestBinarSearchTreeValue {

    // time : O(n) space : O(1)
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - res)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }


    // time : O(n) space : O(n)
    public int closestValue2(TreeNode root, double target) {
        return helper(root, target, root.val);
    }

    public int helper(TreeNode root, double target, int val) {
            if (root == null) return val;
            if (Math.abs(root.val - target) < Math.abs(val - target)) {
                val = root.val;
            }
            if (root.val < target) {
                val = helper(root.right, target, val);
            } else if (root.val > target) {
                val = helper(root.left, target, val);
            }
            return val;
    }
}
