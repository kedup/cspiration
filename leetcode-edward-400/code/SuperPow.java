package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SuperPow
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 372. Super Pow
 */
public class SuperPow {
    /**
     * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely
     * large positive integer given in the form of an array.

     a^b%1337

     Example1:

     a = 2
     b = [3]

     Result: 8
     Example2:

     a = 2
     b = [1,0]

     Result: 1024

     (a*a)%c=(a%c)*(a%c)%c

     [3,2]
     30 2

     a^32 = a^30 * a^2 % k

     time : O(1) 不确定
     space : O(n)

     * @param a
     * @param b
     * @return
     */
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length, 1337);
    }

    private int superPow(int a, int[] b, int length, int k) {
        if (length == 1) {
            return powMod(a, b[0], k);
        }
        return powMod(superPow(a, b, length - 1, k), 10, k) * powMod(a, b[length - 1], k) % k;
    }

    private int powMod(int x, int y, int k) {
        x %= k;
        int pow = 1;
        for (int i = 0; i < y; i++) {
            pow = pow * x % k;
        }
        return pow;
    }
}
