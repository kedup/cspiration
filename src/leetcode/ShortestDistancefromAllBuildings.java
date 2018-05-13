package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ShortestDistancefromAllBuildings
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 317. Shortest Distance from All Buildings
 */
public class ShortestDistancefromAllBuildings {
    /**
     * You want to build a house on an empty land which reaches all buildings
     * in the shortest amount of distance. You can only move up, down, left and right.
     * You are given a 2D grid of values 0, 1 or 2, where:

     Each 0 marks an empty land which you can pass by freely.
     Each 1 marks a building which you cannot pass through.
     Each 2 marks an obstacle which you cannot pass through.
     For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

     1 - 0 - 2 - 0 - 1
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0
     |   |   |   |   |
     0 - 0 - 1 - 0 - 0

     The point (1,2) is an ideal empty land to build a house,
     as the total travel distance of 3+3+1=7 is minimal. So return 7.


     int[][] dist
     int[][] nums

     for
        for
            if (grid[i][j] == '1')
               BFS

     * time: O(m^2 * n^2)
     * space: O(mn)
     * @param grid
     * @return
     */

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] nums = new int[m][n];
        int buildingNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    bfs(grid, i, j, dist, nums);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dist[i][j] != 0 && nums[i][j] == buildingNum) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     1 - 0 - 2 - 0 - 1
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0
     |   |   |   |   |
     0 - 0 - 1 - 0 - 0

     visited :
     1 - 0 - 0 - 0 - 0
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0

     dist :
     0 - 1 - 0 - 0 - 0
     |   |   |   |   |
     1 - 0 - 0 - 0 - 0
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0

     nums :
     0 - 1 - 0 - 0 - 0
     |   |   |   |   |
     1 - 0 - 0 - 0 - 0
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0
     queue : (0,0)
     queue : (0,1) (1,0)
     queue : ()


     * @param grid
     * @param row
     * @param col
     * @param dist
     * @param nums
     */

    private void bfs(int[][] grid, int row, int col, int[][] dist, int[][] nums) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        int distance = 0;

        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < dirs.length; k++) {
                    int x = cur[0] + dirs[k][0];
                    int y = cur[1] + dirs[k][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        dist[x][y] += distance;
                        nums[x][y]++;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }


    }
}
