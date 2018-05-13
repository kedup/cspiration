package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : IntersectionofTwoLinkedLists
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 160. Intersection of Two Linked Lists
 */
public class IntersectionofTwoLinkedLists {
    /**
     * For example, the following two linked lists:

     A:          a1 → a2
                         ↘
                         c1 → c2 → c3
                         ↗
     B:     b1 → b2 → b3
     begin to intersect at node c1.

     time : O(n);
     space : O(1);

     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = len(headA);
        int lenB = len(headB);
        if (lenA > lenB) {
            while (lenA != lenB) {
                headA = headA.next;
                lenA--;
            }
        } else {
            while (lenA != lenB) {
                headB = headB.next;
                lenB--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public int len(ListNode head) {
        int len = 1;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    /**
     *
     A:          a1 → a2
                         ↘
                         c1 → c2 → c3
                         ↗
     B:     b1 → b2 → b3
     begin to intersect at node c1.

     A : a1 → a2 -> c1 → c2 → c3 -> b1 → b2 → b3 -> c1 → c2 → c3
     B : b1 → b2 → b3 -> c1 → c2 → c3 -> a1 → a2 -> c1 → c2 → c3

     time : O(m + n);
     space : O(1);

     * @param headA
     * @param headB
     * @return
     */

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
