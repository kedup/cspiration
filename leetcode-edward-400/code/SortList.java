package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SortList
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 148. Sort List
 */
public class SortList {
    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     *
     * time : O(nlogn)
     * space : O(n)
     *
     * @param head
     * @return
     */

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = getMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        return merge(sortList(head), sortList(next));
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a == null) cur.next = b;
        else cur.next = a;
        return dummy.next;
    }
}
