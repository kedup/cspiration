package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : NumberofIslandsII
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 305. Number of Islands II
 */
public class NumberofIslandsII {
    /**
     * A 2d grid map of m rows and n columns is initially filled with water.
     * We may perform an addLand operation which turns the water at position (row, col) into a land.
     * Given a list of positions to operate, count the number of islands after each addLand operation.
     * An island is surrounded by water and is formed by connecting
     * adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.

     Example:

     Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
     Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

     0 0 0
     0 0 0
     0 0 0
     Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

     1 0 0
     0 0 0   Number of islands = 1
     0 0 0
     Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

     1 1 0
     0 0 0   Number of islands = 1
     0 0 0
     Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

     1 1 0
     0 0 1   Number of islands = 2
     0 0 0
     Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

     1 1 0
     0 0 1   Number of islands = 3
     0 1 0
     We return the result as an array: [1, 1, 2, 3]

     time : O(k^2)
     space : O(m * n)
     */
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;

        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);

        for (int[] pair : positions) {
            int position = n * pair[0] + pair[1];
            roots[position] = position;
            count++;

            for (int[] dir : dirs) {
                int x = pair[0] + dir[0];
                int y = pair[1] + dir[1];
                int curPos = n * x + y;
                if (x < 0 || x >= m || y < 0 || y >= n || roots[curPos] == -1) {
                    continue;
                }
                int anoIsland = find(roots, curPos);
                if (position != anoIsland) {
                    roots[position] = anoIsland;
                    position = anoIsland;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    private int find(int[] roots, int i) {
        while (i != roots[i]) {
            i = roots[i];
        }
        return i;
    }
}
