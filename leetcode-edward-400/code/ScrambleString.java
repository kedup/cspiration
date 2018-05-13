package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ScrambleString
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 87. Scramble String
 */
public class ScrambleString {

    /**

     time : O(n!)
     space : O(n)

     * @param s1
     * @param s2
     * @return
     */

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.equals(s2)) return true;

        int[] letters = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) return false;
        }
        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0, i), s2.substring(len - i))
                    && isScramble(s1.substring(i), s2.substring(0, len - i))) return true;
        }
        return false;
    }
}
