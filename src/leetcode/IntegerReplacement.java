package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : IntegerReplacement
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 397. Integer Replacement
 */
public class IntegerReplacement {
    /**
     * Given a positive integer n and you can do operations as follow:

     If n is even, replace n with n/2.
     If n is odd, you can replace n with either n + 1 or n - 1.
     What is the minimum number of replacements needed for n to become 1?

     Example 1:

     Input:
     8

     Output:
     3

     Explanation:
     8 -> 4 -> 2 -> 1
     Example 2:

     Input:
     7

     Output:
     4

     Explanation:
     7 -> 8 -> 4 -> 2 -> 1
     or
     7 -> 6 -> 3 -> 2 -> 1

     time : O(logn)
     space : O(1)
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        long N = n;
        int res = 0;
        while (N != 1) {
            if (N % 2 == 0) {
                N >>= 1;
            } else {
                if (N == 3) {
                    res += 2;
                    break;
                }
                N = (N & 2) == 2 ? N + 1 : N - 1;
            }
        }
        return res;
    }

    /**
     * time : O(logn)
     * space : O(1)

     * @param n
     * @return
     */

    public int integerReplacement2(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        int res = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                if ( (n + 1) % 4 == 0 && (n - 1 != 2)) {
                    n++;
                } else n--;
            }
            res++;
        }
        return res;
    }
}
