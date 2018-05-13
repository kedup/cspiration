package leetcode;

/**
 * Created by Edward on 28/07/2017.
 */
public class OneEditDistance {
    /**
     * 161. One Edit Distance
     * Given two strings S and T, determine if they are both one edit distance apart.

     1, abcre abere
     2, abdc abc
     3, abc abdc

     abc
     abcd

     time : O(n^2)
     space : O(1)

     * @param s
     * @param t
     * @return
     */
    public static boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return t.substring(i + 1).equals(s.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
