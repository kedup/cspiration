package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindKPairswithSmallestSums
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 373. Find K Pairs with Smallest Sums
 */
public class FindKPairswithSmallestSums {
    /**
     * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

     Define a pair (u,v) which consists of one element from the first array and one element from the second array.

     Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

     Example 1:
     Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

     Return: [1,2],[1,4],[1,6]

     The first 3 pairs are returned from the sequence:
     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

     Example 2:
     Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

     Return: [1,1],[1,1]

     The first 2 pairs are returned from the sequence:
     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
     Example 3:
     Given nums1 = [1,2], nums2 = [3],  k = 3

     Return: [1,3],[2,3]

     All possible pairs are returned from the sequence:
     [1,3],[2,3]

     前 k 个最小：PriorityQueue<int[]> size = k

     nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

     1,6,2  7,2,0  11,2,0

     1,2,0 -> 1,4,1 -> 1,6,2



     time : O(kLogk)
     space : O(k)

     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (!pq.isEmpty() && k-- > 0) {
            int[] cur = pq.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length - 1) continue;
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}
