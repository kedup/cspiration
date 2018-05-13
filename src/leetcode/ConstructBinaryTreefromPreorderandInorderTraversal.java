package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ConstructBinaryTreefromPreorderandInorderTraversal
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     *    3
         / \
        9  20
      /  \
     15   7

     inorder : 15 9 7 3 20
     preorder : 3 9 15 7 20

     time : O(n)
     space : O(n)

     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

}
