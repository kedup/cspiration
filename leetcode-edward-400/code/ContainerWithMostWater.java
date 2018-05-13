package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ContainerWithMostWater
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 11. Container With Most Water
 */
public class ContainerWithMostWater {

    /**
     * time : O(n)
     * space : O(1)
     * @param height
     * @return
     */

    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else r--;
        }
        return res;
    }
}
