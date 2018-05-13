package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PartitionList
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 86. Partition List
 */
public class PartitionList {
    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
     * greater than or equal to x.

     You should preserve the original relative order of the nodes in each of the two partitions.

     For example,
     Given 1->4->3->2->5->2 and x = 3,
     return 1->2->2->4->3->5.


     1->4->3->2->5->2 and x = 3
     smallHead -> 1 -> 2 -> 2 ->
                          small
     bigHead -> 4 -> 3 -> 5 ->
                         big

     time : O(n)
     space : O(n)


     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0),
                bigHead = new ListNode(0),
                small = smallHead,
                big = bigHead;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                small.next = temp;
                small = small.next;
            } else {
                big.next = temp;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
    }
}
