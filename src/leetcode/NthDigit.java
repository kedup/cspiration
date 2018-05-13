package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : NthDigit
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 400. Nth Digit
 */
public class NthDigit {
    /**
     *Example 2:

     Input:
     11

     Output:
     0

     Explanation:
     The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.


     10 - 99 : 90 * 2 = 180

     13:
     n = 13 - 9 = 4;
     len = 2;
     count = 90
     start = 11

     time : < O(n)
     space : O(1)


     * @param n
     * @return
     */

    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = Integer.toString(start);
        return s.charAt((n - 1) % len) - '0';
    }
}
