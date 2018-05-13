package leetcode;

import java.util.Random;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LinkedListRandomNode
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class LinkedListRandomNode {
    /**
     * 382. Linked List Random Node
     *
     * time : O(n);
     * @param head
     */

    private ListNode head;
    private Random rmd;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        rmd = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode temp = head;
        int res = temp.val;
        int i = 1;
        while (temp.next != null) {
            temp = temp.next;
            if (rmd.nextInt(++i) == 0) {
                res = temp.val;
            }
        }
        return res;
    }
}
