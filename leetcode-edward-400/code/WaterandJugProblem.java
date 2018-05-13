package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : WaterandJugProblem
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 365. Water and Jug Problem
 */
public class WaterandJugProblem {
    /**
     * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available.
     * You need to determine whether it is possible to measure exactly z litres using these two jugs.

     If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

     Operations allowed:

     Fill any of the jugs completely with water.
     Empty any of the jugs.
     Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
     Example 1: (From the famous "Die Hard" example)

     Input: x = 3, y = 5, z = 4
     Output: True
     Example 2:

     Input: x = 2, y = 6, z = 5
     Output: False

     x * m + y * n = z
     3 * -2 + 5 * 2 = 4
     + : 装水
     - : 倒水

     x * m + y * n = z
     贝祖定理: z = gcd(x,y) * i  z % gcd(x,y) = 0

     GCD : 求最大公约数(a,b)

     a / b = c ... d
     d = 0 : b
           : b / d = f ... e
     e = 0 : d

     a = 3 b = 6
         6     3
         3     0

     1 2 4

     time : < O(n) O(1)
     space : (n)

     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == 2) return true;
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
