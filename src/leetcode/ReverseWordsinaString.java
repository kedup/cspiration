package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ReverseWordsinaString
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ReverseWordsinaString {
    /**
     * 151. Reverse Words in a String
     * For example,
     Given s = "the sky is blue",
     return "blue is sky the".

     * @param s
     * @return
     */

    //time : O(n), space : O(n)
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >=0; i--) {
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }

    // time : O(n) space : O(n)
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;
        char[] ch = s.toCharArray();
        reverse(ch, 0, s.length() - 1);
        reverseWord(ch, s.length());
        return cleanSpaces(ch, s.length());
    }

    private void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char temp = ch[i];
            ch[i++] = ch[j];
            ch[j--] = temp;
        }
    }
    private void reverseWord(char[] ch, int len) {
        int i = 0;
        int j = 0;
        while (i < len) {
            while (i < j || i < len && ch[i] == ' ') i++;
            while (j < i || j < len && ch[j] != ' ') j++;
            reverse(ch, i, j - 1);
        }
    }
    private String cleanSpaces(char[] ch, int len) {
        int i = 0;
        int j = 0;
        while (j < len) {
            while (j < len && ch[j] == ' ') j++;
            while (j < len && ch[j] != ' ') ch[i++] = ch[j++];
            while (j < len && ch[j] == ' ') j++;
            if (j < len) ch[i++] = ' ';
        }
        return String.valueOf(ch).substring(0, i);
    }
}
