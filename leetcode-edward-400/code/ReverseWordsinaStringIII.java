package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ReverseWordsinaStringIII
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ReverseWordsinaStringIII {
    /**
     * 557. Reverse Words in a String III
     * Example 1:
     Input: "Let's take LeetCode contest"
     Output: "s'teL ekat edoCteeL tsetnoc"

     time : O(n);
     space : O(n);
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] arr = s.toCharArray();
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == ' ') {
                reverse(arr, i, j - 1);
                i = j + 1;
            }
        }
        reverse(arr, i, arr.length - 1);
        return String.valueOf(arr);
    }
    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            str[i] = new StringBuilder(str[i]).reverse().toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String st : str) {
            sb.append(st + " ");
        }
        return sb.toString().trim();
    }
}
