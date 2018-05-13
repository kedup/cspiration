package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ArithmeticSlices
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 413. Arithmetic Slices
 */
public class ArithmeticSlices {
    /**
     * Example:

     A = [1, 2, 3, 4]

     return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.

     数组	   等差数列的数目	    与上一数组的等差数列数目比较
     1 2 3	         1	            1 - 0 = 1
     1 2 3 4	     3	            3 - 1 = 2
     1 2 3 4 5	     6	            6 - 3 = 3
     1 2 3 4 5 6	10	            10 - 6 = 4
     1 2 3 4 5 6 7	15	            15 - 10 = 5

     time : O(n)
     space : O(1)

     * @param A
     * @return
     */

    public int numberOfArithmeticSlices(int[] A) {
        int cur = 0, res = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur++;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }
}
