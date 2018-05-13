package leetcode;

/**
 * Created by Edward on 24/07/2017.
 */
public class PlusOne {
    /**
     * 66. Plus One
     * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

     You may assume the integer do not contain any leading zero, except the number 0 itself.

     The digits are stored such that the most significant digit is at the head of the list.

     case1 : 1011 1012
     case2 : 1099 1100
     case3 : 9999 10000

     time : O(n);
     space : O(n);
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) return digits;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;

        return res;
    }
}
