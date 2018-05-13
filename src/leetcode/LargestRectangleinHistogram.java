package leetcode;

import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LargestRectangleinHistogram
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 84. Largest Rectangle in Histogram
 */
public class LargestRectangleinHistogram {
    /**
     * For example,
     Given heights = [2,1,5,6,2,3],
     return 10.

     stack : 1，升序，2，小于，计算
      0,1,2,3,4,5,6
     [2,1,5,6,2,3,0]

     stack : 1
     2 : push
     1 : height = 2 start = -1 res = 2
     5 : push
     6 : push
     2 : height = 6 start = 2 area = 6 res = 6
         height = 5 start = 1 area = 10 res = 10
     3 push
     0 : height = 2 start = 1 area = 8
         height = 1 start = -1 area = 6

     res = 10

     time : O(n)
     space : O(n)


     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = height * (i - start - 1);
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        return res;
    }
}
