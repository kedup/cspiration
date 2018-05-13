package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FactorialTrailingZeroes
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 172. Factorial Trailing Zeroes
 */
public class FactorialTrailingZeroes {
    /**
     * Given an integer n, return the number of trailing zeroes in n!.

     Note: Your solution should be in logarithmic time complexity.


     time : O(logn)
     space : O(n)

     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
