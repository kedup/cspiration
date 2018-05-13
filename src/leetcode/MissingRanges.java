package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MissingRanges
 * Creator : Edward
 * Date : Sep, 2017
 * Description : 163. Missing Ranges
 */
public class MissingRanges {
    /**
     * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper],
     * return its missing ranges.

     For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

     [2147483647] 0 2147483647
     ["0->2147483646"]
     ["0->2147483646","-2147483648->2147483647"]

     time : O(n)
     space : O(1)

     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long alower = (long)lower, aupper = (long)upper;
        for (int num : nums) {
            if (num == alower) {
                alower++;
            } else if (alower < num) {
                if (alower + 1 == num) {
                    res.add(String.valueOf(alower));
                } else {
                    res.add(alower + "->" + (num - 1));
                }
                alower = (long)num + 1;
            }
        }
        if (alower == aupper) res.add(String.valueOf(alower));
        else if (alower < aupper) res.add(alower + "->" + aupper);
        return res;
    }
}
