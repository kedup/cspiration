package leetcode;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.*;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RearrangeStringkDistanceApart
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 358. Rearrange String k Distance Apart
 */
public class RearrangeStringkDistanceApart {

    /**
     * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

     All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

     Example 1:
     s = "aabbcc", k = 3

     Result: "abcabc"

     The same letters are at least distance 3 from each other.
     Example 2:
     s = "aaabc", k = 3 

     Answer: ""

     It is not possible to rearrange the string.
     Example 3:
     s = "aaadbbcc", k = 2

     Answer: "abacabcd"

     Another possible answer is: "abcabcda"

     The same letters are at least distance 2 from each other.


     * @param s
     * @param k
     * @return
     */

    // time : O(n) space : O(n)
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] count = new int[26];
        int[] valid = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int nextLetter = findNext(count, valid, i);
            if (nextLetter == -1) {
                return "";
            }
            res.append((char)('a' + nextLetter));
            valid[nextLetter] = i + k;
            count[nextLetter]--;
        }
        return res.toString();
    }

    private int findNext(int[] count, int[] valid, int index) {
        int max = 0, res = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && valid[i] <= index) {
                res = i;
                max = count[i];
            }
        }
        return res;
    }

    // time : O(nlogn) space : O(n)
    public String rearrangeString2(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        pq.addAll(map.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            res.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            queue.offer(cur);
            if (queue.size() < k) continue;
            Map.Entry<Character, Integer> front = queue.poll();
            if (front.getValue() > 0) {
                pq.offer(front);
            }
        }
        return res.length() == s.length() ? res.toString() : "";
    }
}
