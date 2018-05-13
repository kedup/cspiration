package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : IntegerBreak
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 343. Integer Break
 */
public class IntegerBreak {
    /**
     * Given a positive integer n, break it into the sum of at least two positive integers and
     * maximize the product of those integers. Return the maximum product you can get.

     For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

     2 : 1 + 1
     3 : 2 + 1
     4 : 2 + 2
     5 : 3 + 2
     6 : 3 + 3
     7 : 3 + 4
     8 : 3 + 3 + 2
     9 : 3 + 3 + 3
     10 : 3 + 3 + 4

     time : < O(n) O(1)
     space : O(1)

     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
