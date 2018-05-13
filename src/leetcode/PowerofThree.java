package leetcode;

import sun.nio.cs.ext.MacHebrew;

/**
 * Created by Edward on 28/07/2017.
 */
public class PowerofThree {
    /**
     * 326. Power of Three
     * Given an integer, write a function to determine if it is a power of three.

     Follow up:
     Could you do it without using any loop / recursion?

     space : O(1);

     * @param n
     * @return
     */

    // time : O(n);

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    // time : O(1);

    public static boolean isPowerOfThree2(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
