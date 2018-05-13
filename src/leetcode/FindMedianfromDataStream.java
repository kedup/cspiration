package leetcode;

import java.util.PriorityQueue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindMedianfromDataStream
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 295. Find Median from Data Stream
 */
public class FindMedianfromDataStream {
    /**
     * For example:

     addNum(1)
     addNum(2)
     findMedian() -> 1.5
     addNum(3)
     findMedian() -> 2

     1 2 -3 4
     -3 1 2 4

     small : 3 -1
     large : 2 4

     time : O(logn)
     space : O(n)
     */

    private PriorityQueue<Long> small;
    private PriorityQueue<Long> large;

    public FindMedianfromDataStream() {  // MedianFinder()
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.add((long)num);
        small.add(-large.poll());
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2;
    }
}
