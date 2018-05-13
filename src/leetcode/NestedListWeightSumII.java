package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : NestedListWeightSumII
 * Creator : Edward
 * Date : Aug, 2017
 * Description : 364. Nested List Weight Sum II
 */
public class NestedListWeightSumII {
    /**
     * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

     Each element is either an integer, or a list -- whose elements may also be integers or other lists.

     Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

     Example 1:
     Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

     Example 2:
     Given the list [1,[4,[6]]], return 17.
     (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)

     DFS 2 + DFS(2, Nest)
       DFS 2 +

     nextList : 1, 1, 1, 1

     res = 2 + 2 + 4
        dfs(next, 2) res = 2 + 4

     time : O(n);
     space : O(n);
     * @param nestedList
     * @return
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> nestedList, int res) {
        List<NestedInteger> nextList = new LinkedList<>();
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                res += nest.getInteger();
            } else {
                nextList.addAll(nest.getList());
            }
        }
        res += nextList.isEmpty() ? 0 : helper(nestedList, res);
        return res;
    }

    public int depthSumInverse2(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int sum = 0;
        int res = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextList = new LinkedList<>();
            for (NestedInteger nest : nestedList) {
                if (nest.isInteger()) {
                    sum += nest.getInteger();
                } else {
                    nextList.addAll(nest.getList());
                }
            }
            res += sum;
            nestedList = nextList;
        }
        return res;
    }
}
