package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CombinationSumIII
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class CombinationSumIII {

    /**
     * 216. Combination Sum III
     * Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


     Example 1:

     Input: k = 3, n = 7

     Output:

     [[1,2,4]]

     Example 2:

     Input: k = 3, n = 9

     Output:

     [[1,2,6], [1,3,5], [2,3,4]]

     time : O(2^n)
     space : O(n);
     * @param k
     * @param n
     * @return
     */

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <=9; i++) {
            list.add(i);
            helper(res, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
