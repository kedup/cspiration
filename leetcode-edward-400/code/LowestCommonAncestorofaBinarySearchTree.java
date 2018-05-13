package leetcode;

/**
 * Created by Edward on 28/07/2017.
 */
public class LowestCommonAncestorofaBinarySearchTree {
    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

     According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as
     the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

     time : O(n);
     space : O(n);
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
