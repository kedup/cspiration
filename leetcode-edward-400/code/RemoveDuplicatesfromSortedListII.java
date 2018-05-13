package leetcode;

/**
 * Created by Edward on 25/07/2017.
 */
public class RemoveDuplicatesfromSortedListII {

    /**
     * 82. Remove Duplicates from Sorted List II (83. Remove Duplicates from Sorted List: follow up)
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

     For example,
     Given 0->1->2->3->3->4->4->5, return 1->2->5.
     Given 0->1->1->1->2->3, return 2->3.
     time : O(n);
     space : O(1);
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next !=null) {
            if (p.next.val == p.next.next.val) {
                int sameNum = p.next.val;
                while (p.next != null && p.next.val == sameNum) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
