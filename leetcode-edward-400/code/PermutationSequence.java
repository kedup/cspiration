package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PermutationSequence
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 60. Permutation Sequence
 */
public class PermutationSequence {
    /**
     * The set [1,2,3,…,n] contains a total of n! unique permutations.

     By listing and labeling all of the permutations in order,
     We get the following sequence (ie, for n = 3):

     "123"
     "132"
     "213"
     "231"
     "312"
     "321"
     Given n and k, return the kth permutation sequence.

     Note: Given n will be between 1 and 9 inclusive.

     1， 2， 3， 4:

     1 + {2, 3, 4}
     2 + {1, 3, 4}
     3 + {1, 2, 4}
     4 + {1, 2, 3}

     18 : 3421

     res  :
     fact : 1 1 2 6

     k = 17

     i = 4    index = 17 / 6 = 2 k = 17 % 6 = 5
     i = 3    index = 5 / 2 = 2 k = 5 % 2 = 1
     i = 2    index = 1 / 1 = 1 k = 1 % 1 = 0

     4 3 2 1
     3 4 2 1

     time : O(n)
     space : O(n)

     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(res.get(index));
            res.remove(index);
        }
        return sb.toString();
    }
}
