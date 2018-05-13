package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : OddEvenLinkedList
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class OddEvenLinkedList {
    /**
     * 328. Odd Even Linked List
     * Example:
     *
     Given 1->2->3->4->5->NULL,
     return 1->3->5->2->4->NULL.

     1 -> 3    2 -> 4

     3 -> 4 -> 5 -> 6


     time : O(n);
     space : O(1);
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
