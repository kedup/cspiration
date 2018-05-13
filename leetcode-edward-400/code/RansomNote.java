package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RansomNote
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 383. Ransom Note
 */
public class RansomNote {
    /**
     * You may assume that both strings contain only lowercase letters.

     canConstruct("a", "b") -> false
     canConstruct("aa", "ab") -> false
     canConstruct("aa", "aab") -> true

     time : O(n)
     space : O(1)

     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--count[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
