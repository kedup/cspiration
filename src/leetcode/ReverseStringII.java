package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ReverseStringII
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ReverseStringII {
    /**
     * 541. Reverse String II
     * Given a string and an integer k, you need to reverse the first k characters for every 2k
     * characters counting from the start of the string. If there are less than k characters left,
     * reverse all of them. If there are less than 2k but greater than or equal to k characters, then
     * reverse the first k characters and left the other as original.


     time : O(n);
     space : O(n);
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            int j = Math.min(i + k - 1, s.length() - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    public void swap(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
