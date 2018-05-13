package leetcode;

import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PlusOneLinkedList
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class PlusOneLinkedList {
    /**
     * 369. Plus One Linked List
     * Input:
     1->2->3

     Output:
     1->2->4

     time : O(n)
     space : O(1)
     * @param head
     * @return
     */

    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) i = j;
        }
        i.val++;
        i = i.next;
        while (i != null) {
            i.val = 0;
            i = i.next;
        }
        if (dummy.val == 0) return dummy.next;
        return dummy;
    }

    /**

     1 -> 0 -> 0 -> 0

     * @param head
     * @return
     */
    public ListNode plusOne2(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int carry = 1;
        while (carry > 0 || cur.next != null) {
            if (cur.next != null) {
                cur = cur.next;
                carry += cur.val;
                cur.val = carry % 10;
                carry /= 10;
            } else {
                cur.next = new ListNode(carry);
                cur = cur.next;
                carry = 0;
            }
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}
