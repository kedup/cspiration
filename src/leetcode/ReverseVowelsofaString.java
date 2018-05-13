package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ReverseVowelsofaString
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ReverseVowelsofaString {
    /**
     * 345. Reverse Vowels of a String
     * Write a function that takes a string as input and reverse only the vowels of a string.

     Example 1:
     Given s = "hello", return "holle".

     Example 2:
     Given s = "leetcode", return "leotcede".

     time : O(n);
     space : O(n);
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        char[] array = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && vowels.indexOf(array[start]) == -1) {
                start++;
            }
            while (start < end && vowels.indexOf(array[end]) == -1) {
                end--;
            }
            char temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
        return String.valueOf(array);
    }
}
