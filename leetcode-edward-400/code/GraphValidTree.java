package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : GraphValidTree
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 261. Graph Valid Tree
 */
public class GraphValidTree {
    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
     * write a function to check whether these edges make up a valid tree.

     For example:

     Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

     Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

     2 -- 0 -- 1 -- 4
          |
          3

          4
          |
     0 -- 1 -- 2
           \  /
            3


     time : O(edges * nodes)
     space : O(n)

     * @param n
     * @param edges
     * @return
     */

    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) return true;
        if (n < 1 || edges == null || edges.length != n - 1) return false;

        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }

        for (int[] pair : edges) {
            int x = find(roots, pair[0]);
            int y = find(roots, pair[1]);
            if (x == y) return false;
            roots[x] = y;
        }
        return true;
    }

    private int find(int[] roots, int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }

    public boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        boolean res = helper(graph, visited, 0, -1);
        if (res == false) return false;
        return visited.size() == n ? true : false;
    }

    private boolean helper(List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent) {
        List<Integer> sub = graph.get(node);
        for (int v : sub) {
            if (v == parent) continue;
            if (visited.contains(v)) return false;
            visited.add(v);
            boolean res = helper(graph, visited, v, node);
            if (res == false) return false;
        }
        return true;
    }
}
