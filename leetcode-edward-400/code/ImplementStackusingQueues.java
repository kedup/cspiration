package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ImplementStackusingQueues
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ImplementStackusingQueues {
    /**
     * 225. Implement Stack using Queues
     */
    Queue<Integer> queue;

    /** Initialize your data structure here.  构造函数因为类而不一样*/
    public ImplementStackusingQueues() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
