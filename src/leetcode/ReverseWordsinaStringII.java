package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ReverseWordsinaStringII
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ReverseWordsinaStringII {
    /**
     * 186. Reverse Words in a String II
     * For example,
     Given s = "the sky is blue",
     return "blue is sky the"

     time : O(n) space : O(1)
     * @param s
     */
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int r = 0;
        while (r < s.length) {
            int l = r;
            while (r < s.length && s[r] != ' ') {
                r++;
            }
            reverse(s, l, r - 1);
            r++;
        }
    }
    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
