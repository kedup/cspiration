package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : UglyNumber
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 263. Ugly Number
 */
public class UglyNumber {
    /**
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

     Note that 1 is typically treated as an ugly number.

     time : O(n)
     space : O(1)

     * @param num
     * @return
     */

    public boolean isUgly(int num) {
        if (num == 1) return true;
        if (num == 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }

    public boolean isUgly2(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
