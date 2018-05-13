package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PopulatingNextRightPointersinEachNode
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 116. Populating Next Right Pointers in Each Node
 */
public class PopulatingNextRightPointersinEachNode {
    /**
     * For example,
     Given the following perfect binary tree,
          1
        /  \
       2    3
      / \  / \
     4  5  6  7
     After calling your function, the tree should look like:
          1 -> NULL
        /  \
       2 -> 3 -> NULL
      / \  / \
     4->5->6->7 -> NULL

     time : O(n);
     space : O(n);

     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

    //space : O(1)
    public void connect2(TreeLinkNode root) {
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode cur = start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
    }
}
