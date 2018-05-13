package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : IsSubsequence
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class IsSubsequence {
    /**
     * 392. Is Subsequence
     * Example 1:
     s = "abc", t = "ahbgdc"

     Return true.

     Example 2:
     s = "axc", t = "ahbgdc"

     Return false.

     time : O(n);
     space : O(1);
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }
}
