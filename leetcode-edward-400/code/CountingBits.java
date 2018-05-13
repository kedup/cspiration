package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CountingBits
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 338. Counting Bits
 */
public class CountingBits {
    /**
     * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
     * the number of 1's in their binary representation and return them as an array.
     *
     * https://www.cnblogs.com/grandyang/p/5294255.html

     Example:

     For num = 5 you should return [0,1,1,2,1,2].

     8 = 1000 0111 = 0000 i&(i-1)

     i    bit    '1'  i&(i-1)
     0    0000    0           0
     -----------------------
     1    0001    1    0000   1
     -----------------------
     2    0010    1    0000   1
     3    0011    2    0010   2
     -----------------------
     4    0100    1    0000
     5    0101    2    0100
     6    0110    2    0100
     7    0111    3    0110
     -----------------------
     8    1000    1    0000
     9    1001    2    1000
     10   1010    2    1000
     11   1011    3    1010
     12   1100    2    1000
     13   1101    3    1100
     14   1110    3    1100
     15   1111    4    1110

     time : O(n)
     space : O(n)

     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
