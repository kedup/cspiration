package leetcode;

import java.util.HashSet;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LineReflection
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 356. Line Reflection
 */
public class LineReflection {
    /**
     * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

     Example 1:
     Given points = [[1,1],[-1,1]], return true.

     Example 2:
     Given points = [[1,1],[-1,-1]], return false.

     x1 + x2 = c
     min max

     x1 = c - x2

     平行于y轴 : x : 对称 (两个点)
                y : 相同

     HashSet
     1, 找出关于哪个轴对称
     2, check

     "1,1" "-1,1"

     x2 = sum - pair

     time : O(n)
     space : O(n)

     * @param points
     * @return
     */
    public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] pair : points) {
            set.add(pair[0] + "," + pair[1]);
            min = Math.min(min, pair[0]);
            max = Math.max(max, pair[0]);
        }
        int sum = min + max;
        for (int[] pair : points) {
            if (!set.contains(sum - pair[0] + "," + pair[1])) {
                return false;
            }
        }
        return true;
    }
}
