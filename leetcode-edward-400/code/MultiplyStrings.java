package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MultiplyStrings
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 43. Multiply Strings
 */
public class MultiplyStrings {
    /**
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

     Note:

     The length of both num1 and num2 is < 110.
     Both num1 and num2 contains only digits 0-9.
     Both num1 and num2 does not contain any leading zero.
     You must not use any built-in BigInteger library or convert the inputs to integer directly.

     time : O(n * m)
     space : O(n + m)

     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "0";
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = product + digits[p2];
                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int digit : digits) {
            if (!(digit == 0 && res.length() == 0)) {
                res.append(digit);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
