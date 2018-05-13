package leetcode;

import java.util.HashMap;
import java.util.Random;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CopyListwithRandomPointer
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
public class CopyListwithRandomPointer {
    /**
     * 138. Copy List with Random Pointer
     * A linked list is given such that each node contains an additional random pointer which could
     * point to any node in the list or null.

     Return a deep copy of the list

     time : O(n);
     space : O(n);
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**

     1->1'->2->2'->3->3'->4->4'

     1'->2'->3'->4'
     * @param head
     * @return
     */
    public RandomListNode copyRandomList2(RandomListNode head) {
        RandomListNode cur = head;
        RandomListNode next;
        //next copy
        while (cur != null) {
            next = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        cur = head;
        //random copy
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy;
        RandomListNode copycur = dummy;

        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copycur.next = copy;
            copycur = copy;
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }
}
