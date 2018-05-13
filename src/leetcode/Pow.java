package leetcode;

/**
 * Created by Edward on 27/07/2017.
 */
public class Pow {
    /**
     * 50. Pow(x, n)
     * Implement pow(x, n).


     eg. 2^2 = 2^1 * 2^1 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) = (1 * 1 * 2) * (1 * 1 * 2) = 4

     eg. 2^3 = 2^1 * 2^1 * 2 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) * 2 = (1 * 1 * 2) * (1 * 1 * 2) * 2 = 8

     time : O(logn);
     space : O(n)/O(1)

     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {
        if (n > 0) {
            return pow(x, n);
        } else {
            return  1.0 / pow(x, n);
        }
    }
    public static double pow (double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

    public static double myPow2(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        // int : -6.. ~ +6..  -2^32 ~ 2 ^32-1 Integer.MIN_VALUE
        long abs = Math.abs((long)n);
        while (abs > 0) {
            if (abs % 2 != 0) {
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        if (n < 0) {
            return 1.0 / res;
        }
        return res;
    }
}
