package leetcode;

import java.util.*;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : AlienDictionary
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 269. Alien Dictionary
 */
public class AlienDictionary {
    /**
     * There is a new alien language which uses the latin alphabet.
     * However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary,
     * where words are sorted lexicographically by the rules of this new language. Derive the order of letters
     * in this language.

     Example 1:
     Given the following words in dictionary,

     [
     "wrt",
     "wrf",
     "er",
     "ett",
     "rftt"
     ]
     The correct order is: "wertf".

     Example 2:
     Given the following words in dictionary,

     [
     "z",
     "x"
     ]
     The correct order is: "zx".

     Example 3:
     Given the following words in dictionary,

     [
     "z",
     "x",
     "z"
     ]
     The order is invalid, so return "".

     图 -> 入度为0 -> BFS

     count = 5

     degree :
     w : 1
     e : 1
     r : 1
     t : 1
     f : 2

     time : (V + E) -> O(n * words(max))
     space : O(n) -> O(26) -> O(1)

     * @param words
     * @return
     */
    public static String alienOrder(String[] words) {

        if (words == null || words.length == 0) return "";

        StringBuilder res = new StringBuilder();
        HashMap<Character, Set<Character>> map = new HashMap<>();
        int[] degree = new int[26];
        int count = 0;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degree[c - 'a'] == 0) {
                    count++;
                    degree[c - 'a'] = 1;
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            char[] cur = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            int len = Math.min(cur.length, next.length);
            for (int j = 0; j < len; j++) {
                if (cur[j] != next[j]) {
                    if (!map.containsKey(cur[j])) {
                        map.put(cur[j], new HashSet<>());
                    }
                    if (map.get(cur[j]).add(next[j])) {
                        degree[next[j] - 'a']++;
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 1) {
                queue.offer((char)('a' + i));
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            res.append(c);
            if (map.containsKey(c)) {
                for (char ch : map.get(c)) {
                    if (--degree[ch - 'a'] == 1) {
                        queue.offer(ch);
                    }
                }
            }
        }

        if (res.length() != count) return "";
        return res.toString();
    }

}
