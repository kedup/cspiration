package leetcode;

import java.util.List;
import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : AddTwoNumbersII
 * Creator : Edward
 * Date : Sep, 2017
 * Description : 445. Add Two Numbers II
 */
public class AddTwoNumbersII {
    /**

     Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 8 -> 0 -> 7

     time : O(n)
     space : O(n)

     解法1 : Stack
     解法2 : Reverse

     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode cur = new ListNode(0);
        int sum = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            cur.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = cur;
            cur = head;
            sum /= 10;
        }
        return cur.val == 0 ? cur.next : cur;
    }
}
