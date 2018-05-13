package leetcode;

import java.util.Iterator;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PeekingIterator
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 284. Peeking Iterator
 */
public class PeekingIterator {
    /**
     Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

     Call next() gets you 1, the first element in the list.

     Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

     You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.


     * @param iterator
     */

    private Iterator<Integer> iter;
    private Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    //@Override
    public Integer next() {
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }

    //@Override
    public boolean hasNext() {
        return next != null;
    }
}
