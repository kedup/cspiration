package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ThirdMaximumNumber
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 414. Third Maximum Number
 */
public class ThirdMaximumNumber {
    /**
     * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

     Example 1:
     Input: [3, 2, 1]

     Output: 1

     Explanation: The third maximum is 1.
     Example 2:
     Input: [1, 2]

     Output: 2

     Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     Example 3:
     Input: [2, 2, 3, 1]

     Output: 1

     Explanation: Note that the third maximum here means the third maximum distinct number.
     Both numbers with value 2 are both considered as second maximum.

     time : O(n)
     space : O(1)


     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer num : nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }

    /**
     * time : O(n)
     * space : O(1)
     *
     * @param nums
     * @return
     */

    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)) {
                priorityQueue.offer(num);
                if (priorityQueue.size() > 3) priorityQueue.poll();
            }
        }
        if (priorityQueue.size() == 2) priorityQueue.poll();
        return priorityQueue.peek();
    }

}
