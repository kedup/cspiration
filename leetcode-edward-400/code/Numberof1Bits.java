package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : Numberof1Bits
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 191. Number of 1 Bits
 */
public class Numberof1Bits {
    /**
     * Write a function that takes an unsigned integer and returns the number of ’1' bits it has
     * (also known as the Hamming weight).

     For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
     so the function should return 3.

     使用n&(n-1)的方法：n&(n-1)作用：将n的二进制表示中的最低位为1的改为0
                n              n-1            n&(n-1)
     step1:   110101          110100          110100
     step2:   110100          110011          110000
     step3:   110000          101111          100000
     step4:   100000          011111          000000

     time : O(1) / O(n)
     space : O(1)

     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
