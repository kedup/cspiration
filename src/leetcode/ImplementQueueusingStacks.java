package leetcode;

import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ImplementQueueusingStacks
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ImplementQueueusingStacks {
    /**
     * 232. Implement Queue using Stacks
     *

     */
    /** Initialize your data structure here. 构造函数因为类而不一样*/

    Stack<Integer> s1;
    Stack<Integer> s2;

    public ImplementQueueusingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    // time : O(n);
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!s2.isEmpty()) return s2.pop();
        else {
            while (!s1.isEmpty()) s2.push(s1.pop());
            return s2.pop();
        }
    }

    // time : O(n);
    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) return s2.peek();
        else {
            while (!s1.isEmpty()) s2.push(s1.pop());
            return s2.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

class ImplementQueueusingStacks2 {

    Stack<Integer> s1;
    Stack<Integer> s2;
    private int front;
    /** Initialize your data structure here. */
    public ImplementQueueusingStacks2() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // time : O(n);
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
