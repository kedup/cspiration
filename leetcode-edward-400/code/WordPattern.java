package leetcode;

import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : WordPattern
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 290. Word Pattern
 */
public class WordPattern {
    /**
     * Given a pattern and a string str, find if str follows the same pattern.

     Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

     Examples:
     pattern = "abba", str = "dog cat cat dog" should return true.
     pattern = "abba", str = "dog cat cat fish" should return false.
     pattern = "aaaa", str = "dog cat cat dog" should return false.
     pattern = "abba", str = "dog dog dog dog" should return false.

     time : O(n) space : O(n)

     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
       String[] arr = str.split(" ");
       if (arr.length != pattern.length()) {
           return false;
       }
       HashMap<Character, String> map = new HashMap<>();
       for (int i = 0; i < arr.length; i++) {
           char c = pattern.charAt(i);
           if (map.containsKey(c)) {
               if (!map.get(c).equals(arr[i])) {
                   return false;
               } else {
                   if (map.containsValue(arr[i])) {
                       return false;
                   }
                   map.put(c, arr[i]);
               }
           }
       }
       return true;
    }
}
