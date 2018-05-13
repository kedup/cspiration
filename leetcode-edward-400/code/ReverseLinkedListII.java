package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ReverseLinkedListII
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 92. Reverse Linked List II
 */
public class ReverseLinkedListII {
    /**
     * For example:
     Given 1->2->3->4->5->NULL, m = 2 and n = 4,

     return 1->4->3->2->5->NULL.

     1->2->3->4->5
     p  c  t


     time : O(n);
     space : O(1);

     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        for (int i = 1; i < m; i++) {
            cur = cur.next;
            pre = pre.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
