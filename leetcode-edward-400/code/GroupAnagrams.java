package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Edward on 28/07/2017.
 */
public class GroupAnagrams {
    /**
     * 49. Group Anagrams
     * Given an array of strings, group anagrams together.

     For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     Return:
     [
     ["ate", "eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]


     * @param strs
     * @return
     */

    // time : O(m * n * logn) space : O(n)

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (map.containsKey(s)) {
                List<String> list = res.get(map.get(s));
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, res.size());
                res.add(list);
            }
        }
        return res;
    }

    // time : O(m * n) space : O(n)  counting sort


    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (Character ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            String s = "";
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    s += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));
                }
            }
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
