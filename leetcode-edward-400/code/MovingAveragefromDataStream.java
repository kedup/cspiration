package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MovingAveragefromDataStream
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 346. Moving Average from Data Stream
 */
public class MovingAveragefromDataStream {
    /**
     * MovingAverage m = new MovingAverage(3);
     m.next(1) = 1
     m.next(10) = (1 + 10) / 2
     m.next(3) = (1 + 10 + 3) / 3
     m.next(5) = (10 + 3 + 5) / 3

     time : O(n)
     space : O(n)

     */

    private Queue<Integer> queue;
    private double sum = 0;
    private int size;

    public MovingAveragefromDataStream(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.remove();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }
}
