package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : DungeonGame
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 174. Dungeon Game
 */
public class DungeonGame {

    /**

     -2 -3  3
     -5 -10 1
     10 30 -5

     [7, 5, 2]
     [6, 11, 5]
     [1, 1, 6]

     time : O(m * n)
     space : O(m * n)

     * @param dungeon
     * @return
     */

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(dp[m - 1][i + 1] - dungeon[m - 1][i], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }

}
