package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PowerofFour
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 342. Power of Four
 */
public class PowerofFour {

    /**
     * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

     Example:
     Given num = 16, return true. Given num = 5, return false.

     Follow up: Could you solve it without loops/recursion?


     * @param n
     * @return
     */

    // time : < O(n)
    public boolean isPowerOfFour(int n) {
        if (n > 1) {
            while (n % 4 == 0) {
                n /= 4;
            }
        }
        return n == 1;
    }

    // time : O(1)
    public boolean isPowerOfFour2(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }
}
