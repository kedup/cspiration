package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PaintFence
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 276. Paint Fence
 */
public class PaintFence {
    /**
     * There is a fence with n posts, each post can be painted with one of the k colors.

     You have to paint all the posts such that no more than two adjacent fence posts have the same color.

     Return the total number of ways you can paint the fence.

     1 2 3

     不同: (k - 1) * total
     相同: 2 3 相同，= 2和1 不同的种类

     time : O(n)
     space : O(1)

     * @param n
     * @param k
     * @return
     */
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int same = 0, diff = k, total = k;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = (k - 1) * total;
            total = same + diff;
        }
        return total;
    }
}
