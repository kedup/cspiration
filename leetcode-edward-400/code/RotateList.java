package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RotateList
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 61. Rotate List
 */
public class RotateList {
    /**
     * For example:
     Given 1->2->3->4->5->NULL and k = 2,
     return 4->5->1->2->3->NULL.

     time : O(n);
     space : O(1);

     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode index = head;
        int len = 1;
        while (index.next != null) {
            index = index.next;
            len++;
        }
        index.next = head;
        for (int i = 1; i < len - k % len; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }
}
