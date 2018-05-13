package leetcode;

/**
 * Created by Edward on 25/07/2017.
 */
public class PowerofTwo {
    /**
     * 231. Power of Two
     * Given an integer, write a function to determine if it is a power of two.
     *
     *
     * 2, 4, 8, 16...
     *
     * 2 : 10
     * 4 : 100
     * 8 : 1000
     * 16: 10000
     *
     *
     * n : 16 : 10001
     * n - 1  : 10000
     *
     * time : O(1);
     * space : O(1);
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
