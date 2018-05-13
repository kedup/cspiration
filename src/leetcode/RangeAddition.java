package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RangeAddition
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 370. Range Addition
 */
public class RangeAddition {
    /**
     * Assume you have an array of length n initialized with all 0's and are given k update operations.

     Each operation is represented as a triplet: [startIndex, endIndex, inc]
     which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

     Return the modified array after all k operations were executed.
     * Example:

     Given:

     length = 5,
     updates = [
     [1,  3,  2],
     [2,  4,  3],
     [0,  2, -2]
     ]

     Output:

     [-2, 0, 3, 5, 3]
     Explanation:

     Initial state:
     [ 0, 0, 0, 0, 0 ]

     After applying operation [1, 3, 2]:
     [ 0, 2, 2, 2, 0 ]

     After applying operation [2, 4, 3]:
     [ 0, 2, 5, 5, 3 ]

     After applying operation [0, 2, -2]:
     [-2, 0, 3, 5, 3 ]

     time : O(K + N);
     space : O(n)


     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];
            res[start] += value;
            if (end + 1 < length) {
                res[end + 1] -= value;
            }
        }
        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
