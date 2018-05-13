package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : NumberofConnectedComponentsinanUndirectedGraph
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 323. Number of Connected Components in an Undirected Graph
 */
public class NumberofConnectedComponentsinanUndirectedGraph {
    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
     * write a function to find the number of connected components in an undirected graph.

     Example 1:
     0          3
     |          |
     1 --- 2    4
     Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

     Example 2:
     0           4
     |           |
     1 --- 2 --- 3
     Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

     Note:
     You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
     [0, 1] is the same as [1, 0] and thus will not appear together in edges.

     图 ： 点 - 边 = 1

     n = 5 4 edges n-- = 1

     time : O(edges * nodes)
     space : O(n)

     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {

        int res = n;

        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }

        for (int[] pair : edges) {
            int x = find(roots, pair[0]);
            int y = find(roots, pair[1]);
            if (x != y) {
                roots[x] = y;
                res--;
            }
        }
        return res;
    }

    private int find(int[] roots, int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }
}
