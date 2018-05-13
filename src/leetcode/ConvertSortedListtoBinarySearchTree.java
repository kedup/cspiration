package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ConvertSortedListtoBinarySearchTree
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 109. Convert Sorted List to Binary Search Tree
 */
public class ConvertSortedListtoBinarySearchTree {

    /**

     time : O(n);
     space : O(n);

     * @param head
     * @return
     */

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }
}
