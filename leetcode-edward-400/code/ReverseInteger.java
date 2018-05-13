package leetcode;

/**
 * Created by Edward on 25/07/2017.
 */
public class ReverseInteger {

    /**
     * 7. Reverse Integer
     * Reverse digits of an integer.

     Example1: x = 123, return 321
     Example2: x = -123, return -321

     int :
     -2147483648 ~ 2147483647

     corner case : 越界
     time : O(n);
     space : O(1);
     * @param x
     * @return
     */

    public static int reverse(int x) {

        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int)res;
    }
}
