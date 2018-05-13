package leetcode;

import java.util.PriorityQueue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : KthSmallestElementinaSortedMatrix
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 378. Kth Smallest Element in a Sorted Matrix
 */
public class KthSmallestElementinaSortedMatrix {

    /**
     * Example:

     matrix = [
     [ 1,  5,  9],
     [10, 11, 13],
     [12, 13, 15]
     ],
     k = 8,

     return 13.

     min = 1 max = 15 mid = 8

     1, PriorityQueue : 链表
     2, Binary Search : 数个数

     * @param matrix
     * @param k
     * @return
     */

    // time : (nlogn) space : O(n)
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(matrix.length, (a, b) -> (a.val - b.val));
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple tuple = pq.poll();
            if (tuple.x == matrix.length - 1) continue;
            pq.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
        }
        return pq.poll().val;
    }

    class Tuple {
        int x, y, val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    // time : O(n * log(max - min)) space : O(1)
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            int num = count(matrix, mid);
            if (num >= k) right = mid;
            else left = mid;
        }
        if (count(matrix, right) <= k - 1) return right;
        return left;
    }

    private int count(int[][] matrix, int target) {
        int n = matrix.length;
        int res = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] < target) {
                res += i + 1;
                j++;
            } else i--;
        }
        return res;
    }
}