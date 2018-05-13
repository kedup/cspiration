package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LinkedListCycleII
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 142. Linked List Cycle II
 */
public class LinkedListCycleII {

    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * time : O(n)
     * space : O(1)
     *
     * @param head
     * @return
     */

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
