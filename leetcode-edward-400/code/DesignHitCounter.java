package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : DesignHitCounter
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 362. Design Hit Counter
 */
public class DesignHitCounter {
    /**
     * Design a hit counter which counts the number of hits received in the past 5 minutes.

     Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

     It is possible that several hits arrive roughly at the same time.

     Example:
     HitCounter counter = new HitCounter();

     // hit at timestamp 1.
     counter.hit(1);

     // hit at timestamp 2.
     counter.hit(2);

     // hit at timestamp 3.
     counter.hit(3);

     // get hits at timestamp 4, should return 3.
     counter.getHits(4);

     // hit at timestamp 300.
     counter.hit(300);

     // get hits at timestamp 300, should return 4.
     counter.getHits(300);

     // get hits at timestamp 301, should return 3.
     counter.getHits(301);

     1, Queue
     2, 数组

     */

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public DesignHitCounter() {
        queue = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.poll();
        }
        return queue.size();
    }

    private int[] times;
    private int[] hits;

    public void DesignHitCounter2() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit2(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits2(int timestamp) {
        int res = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                res += hits[i];
            }
        }
        return res;
    }
}
