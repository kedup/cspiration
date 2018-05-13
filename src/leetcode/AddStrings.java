package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : AddStrings
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 415. Add Strings
 */
public class AddStrings {
    /**
     * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

     Note:

     The length of both num1 and num2 is < 5100.
     Both num1 and num2 contains only digits 0-9.
     Both num1 and num2 does not contain any leading zero.
     You must not use any built-in BigInteger library or convert the inputs to integer directly.

     time : O(n + m)
     space : O(n)

     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
