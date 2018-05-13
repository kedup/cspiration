package leetcode;

import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FlattenBinaryTreetoLinkedList
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 114. Flatten Binary Tree to Linked List
 */
public class FlattenBinaryTreetoLinkedList {
    /**
     * For example,
     Given

         1
        / \
       2   5
      / \   \
     3   4   6
     The flattened tree should look like:
     1
      \
      2
       \
       3
        \
        4
         \
         5
          \
          6

     time : O(n)
     space : O(n)


     * @param root
     */
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    public void flatten2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}
