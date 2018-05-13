package leetcode;

import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : AssignCookies
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 455. Assign Cookies
 */
public class AssignCookies {
    /**
     * Example 1:
     Input: [1,2,3], [1,1]

     Output: 1

     Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
     And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
     You need to output 1.
     Example 2:
     Input: [1,2], [1,2,3]

     Output: 2

     Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
     You have 3 cookies and their sizes are big enough to gratify all of the children,
     You need to output 2.

     time : O(nlogn)
     space : O(1)

     */
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                res++;
                i++;
                j++;
            } else if (g[i] > s[j]) {
                j++;
            }
        }
        return res;
    }
}
