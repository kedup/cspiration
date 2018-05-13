package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MeetingRoomsII
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 253. Meeting Rooms II
 */
public class MeetingRoomsII {
    /**


     |___| |____|
       |_____| |___|

     start:
     | |   |   |
               i
     end :
         |   |  |  |
               end

     time : O(nlogn) space : O(n)

     * @param intervals
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0;
        int end = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[end]) {
                res++;
            } else end++;
        }
        return res;
    }


    public int minMeetingRooms2(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (a, b) -> a.end - b.end);
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();
    }
}
